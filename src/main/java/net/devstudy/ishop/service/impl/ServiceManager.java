package net.devstudy.ishop.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.framework.factory.JDBCRepositoryFactory;
import net.devstudy.framework.factory.JDBCTransactionalServiceFactory;
import net.devstudy.ishop.repository.AccountRepository;
import net.devstudy.ishop.repository.CategoryRepository;
import net.devstudy.ishop.repository.OrderItemRepository;
import net.devstudy.ishop.repository.OrderRepository;
import net.devstudy.ishop.repository.ProducerRepository;
import net.devstudy.ishop.repository.ProductRepository;
import net.devstudy.ishop.service.OrderService;
import net.devstudy.ishop.service.ProductService;
import net.devstudy.ishop.service.SocialService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class ServiceManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute("SERVICE_MANAGER", instance);
		}
		return instance;
	}
	public ProductService getProductService() {
		return productService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public SocialService getSocialService() {
		return socialService;
	}
	public String getApplicationProperty(String key) {
		String value = applicationProperties.getProperty(key);
		if(value.startsWith("${sysEnv.")) {
			String keyVal = value.replace("${sysEnv.", "").replace("}", "");
			value = System.getProperty(keyVal);
		}
		return value;
	}
	public void close() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			LOGGER.error("Close datasource failed: "+e.getMessage(), e);
		}
	}

	final Properties applicationProperties = new Properties();
	final BasicDataSource dataSource;
	final ProductRepository productRepository;
	final ProducerRepository producerRepository;
	final CategoryRepository categoryRepository;
	final AccountRepository accountRepository;
	final OrderItemRepository orderItemRepository;
	final OrderRepository orderRepository;
	
	final ProductService productService;
	final OrderService orderService;
	final SocialService socialService;
	
	private ServiceManager(ServletContext context) {
		loadApplicationProperties();
		dataSource = createDataSource();
		
		productRepository = JDBCRepositoryFactory.createRepository(ProductRepository.class);
		producerRepository = JDBCRepositoryFactory.createRepository(ProducerRepository.class);
		categoryRepository = JDBCRepositoryFactory.createRepository(CategoryRepository.class);
		accountRepository = JDBCRepositoryFactory.createRepository(AccountRepository.class);
		orderRepository = JDBCRepositoryFactory.createRepository(OrderRepository.class);
		orderItemRepository = JDBCRepositoryFactory.createRepository(OrderItemRepository.class);
		
		productService = (ProductService) JDBCTransactionalServiceFactory.createTransactionalService(dataSource, new ProductServiceImpl(this)) ;
		orderService = (OrderService) JDBCTransactionalServiceFactory.createTransactionalService(dataSource, new OrderServiceImpl(this));
		socialService = new FacebookSocialService(this);
	}
	
	private BasicDataSource createDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDefaultAutoCommit(false);
		dataSource.setRollbackOnReturn(true);
		dataSource.setDriverClassName(getApplicationProperty("db.driver"));
		dataSource.setUrl(getApplicationProperty("db.url"));
		dataSource.setUsername(getApplicationProperty("db.username"));
		dataSource.setPassword(getApplicationProperty("db.password"));
		dataSource.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
		dataSource.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
		return dataSource;
	}
	
	private void loadApplicationProperties(){
		try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
			applicationProperties.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
