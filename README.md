# Spring and Spring Boot: How does it differ ?
Spring and Spring boot, both are used to build simple, reliable and scalable enterprise applications. The key difference between Spring and Spring Boot lies, not in their design pattern or architectural part but lies in the application configuration part. In Spring based application developers have to make configuration manually where in spring boot there are lots of default configurations that allow faster bootstrapping. Before going to deep dive lets understand the fundamental differences between Spring and Spring boot.

## Spring:
The first version of Spring framework was written by Rod jhonson in his book Expert One-on-One J2EE Design and Development in October 2002 and then licensed under the Apache 2.0 license in June 2003. The Spring framework is a lightweight framework and it includes several modules that provide a range of services. Some common modules are Spring core container, Aspect oriented programming, model view controller, data access, inversion of control container, testing etc. It also support various frameworks like Struts, JSP, Hibernate etc. 

## Spring boot:
Spring boot is actually an extension of spring framework which removes the boilerplate codes by auto configuring and saves lots of time for developers. It provides all the service that Spring framework provides and it is much simpler to use and run. It is basically used to create stand-alone applications and widely used to build rest API's. 

## Project overview:
In this article we will create maven based spring based web mvc application and a spring boot based web application and see some of the key differences of the configurations. 

## Differences:

- **Embedded server:** 
Spring Boot first came to light over Spring with the concept of embedded servers where servers are embedded with deployable jar files. In spring framework, an application needs to build a war(Web Application Archive) or EAR(Enterprise Application Archive) file and then to deploy a war, a web server or an application server is needed to be installed on the server. In Spring boot web, tomcat server is embedded by default and hence web server is not required to deploy. In the above Spring example, we have configured tomcat server manually to run the application. On the other hand in spring boot application tomcat server is embedded so application doesn't require any application server installation.

- **Starter POM**
In our examples we have used maven build tool for dependency management. For Spring webmvc, artifact spring-webmvc is used with version 4.3.3.RELEASE. If we need more dependencies we have to check the compatibility of the version. But Spring boot comes with the Starter POM concept. In Spring boot, we do not have to specify the version number instead we use spring-boot-starter-web artifactId which will internally take core of all the other required dependencies compatible with that version. 
````
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>4.3.3.RELEASE</version>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>4.3.3.RELEASE</version>
  </dependency>
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
  </dependency>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.11</version>
    <scope>test</scope>
  </dependency>
</dependencies>
````

````
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
````

- **Auto Configuration**
In the Spring framework, developers need to set the Configurations manually. In our above Spring example we have to create deployment script (web.xml) and bean definition file (servlet.xml) manually which is typical xml based configurations. On the other hand, in spring boot applications, all the configurations are enabled with just @SpringBootApplication annotations. 

````
@SpringBootApplication
public class SpringBootWebmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebmvcApplication.class, args);
	}

}
````

- **Component Scanning**
When we need to make a class as a bean, we commonly use various annotations. In the Spring framework we have to enable component scan separately in the bean definition file. In Spring boot, we do not need to enable this facility; rather it registers all the annotations defined in the base package where the main class is defined. 

````
<context:component-scan base-package="com.learning"/>
<mvc:annotation-driven/>
````
````
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {

}
````

- **Usages**
Spring framework aims to simplify enterprise java development and is widely used for building enterprise java applications. Although it needs to write lots of boilerplate code, it allows building loosely coupled applications. On the other side Spring boot aims to shorten code length by auto configuring. It is widely used for building Rest API's. It reduces the boilerplate code from spring and it allows building standalone applications. 
