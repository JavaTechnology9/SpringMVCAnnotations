package com.javatechnology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.javatechnology")
public class SpringMVCConfiguration {// <beans>
	
	/*@Bean 
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/
	@Bean
	public TilesConfigurer tilesConfig() {
		TilesConfigurer config=new TilesConfigurer();
		config.setDefinitions(new String[] {"/WEB-INF/tiles/tiles.xml"});
		return config;
	}
	@Bean
	public ViewResolver viewResolver() {
		return new TilesViewResolver();
	}

}
