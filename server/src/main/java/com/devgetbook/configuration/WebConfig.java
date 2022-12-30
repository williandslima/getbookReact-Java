package com.devgetbook.configuration;
//content type
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.devgetbook.serialization.converter.YamlJacksonHttpMesageConverter;

@Configuration // informando ao springBook que aqui e de configuracoes
public class WebConfig implements WebMvcConfigurer {

	private static final MediaType MEDIA_TYPE_APPlICATION_YML = MediaType.valueOf("application/x-yaml");

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJacksonHttpMesageConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub

		// queri param
		configurer.favorParameter(false).ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("x-yaml", MEDIA_TYPE_APPlICATION_YML);

	}



}
