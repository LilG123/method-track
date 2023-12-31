# method-track

## 如何使用


- 直接从maven中央仓库中引入jar包

  ~~~xml
  <!-- https://mvnrepository.com/artifact/io.github.LilG123/method-track -->
  <dependency>
    <groupId>io.github.LilG123</groupId>
    <artifactId>method-track</artifactId>
    <version>0.0.1-RELEASE</version>
  </dependency>


- 修改包扫描范围 不修改会扫描不到切面 由于这边切面是在com.xinan包下 所以需要添加com.xinan的扫描范围

  ![image](https://github.com/LilG123/method-track/assets/111072293/048dd0c8-a80b-4f6e-9ad0-0ce9c03f7ac2)


  ![image](https://github.com/LilG123/method-track/assets/111072293/d6cd8f97-cb17-425c-be59-57e74297ba09)
  
- 在需要监控的方法上写上@MethodTrack()注解

  ![image](https://github.com/LilG123/method-track/assets/111072293/ba8cbf6c-533a-42dc-bce1-7b87e29ef1eb)

- 通过MethodTrackAspect.methodTrackDataMap.get 通过key（如果没有传value 为包名.类名.方法名 传了value为需要传的值） 获取需要监控的接口的健康信息（上一次调用是否成功 上一次调用时间）

  ![image](https://github.com/LilG123/method-track/assets/111072293/fedc426c-98c9-4588-9f75-32db3872f204)
  
- 结果
  
  ![image](https://github.com/LilG123/method-track/assets/111072293/4a8658a3-29d6-49be-839f-39df51db279c)

## 指定value的情况

  1.在需要监控的方法加上注解
  
  ![image](https://github.com/LilG123/method-track/assets/111072293/a8797460-7474-4049-96d8-046f15c88452)

  2.从Map中获取对应方法的健康信息
  
  ![image](https://github.com/LilG123/method-track/assets/111072293/03a674ac-6a09-4b5c-b724-7e6b7f4c21a1)

  3.打印查看结果
  
  ![image](https://github.com/LilG123/method-track/assets/111072293/741d3dbb-0767-4d07-a466-79905954d7f8)


 ## 该注解也可传递需要忽略的异常，使得切面抛出的异常粒度更细

   1.在需要监控的方法加上注解 指定value exludes
   
   ![image](https://github.com/LilG123/method-track/assets/111072293/b18fc372-93a1-4715-b844-68675fe060aa)

   ![image](https://github.com/LilG123/method-track/assets/111072293/c97fb3cb-5f73-4086-b72c-5450d4534125)


