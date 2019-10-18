# msapp
多元海洋

SpringBoot使用MyBatis报错：tk.mybatis.mapper.provider.base.BaseSelectProvider

在SpringBoot的启动类上，使用@MapperScan注解时引入了错误的包下的。　　
正确的：import tk.mybatis.spring.annotation.MapperScan;　　
错误的：import org.mybatis.spring.annotation.MapperScan;


被@DateTimeFormat和@JsonFormat注解修改的属性字段应该是Data类型
@DateTimeFormat转换前端string类型到后端date类型，此字段一般加到属性上面
@JsonFormat转换后端date类型到前端string类型，如果只用到此注解，加到属性上或者方法上都可以；如果跟@DateTimeFormat配合使用，此注解添加到getter方法上面，注意加【timezone="GMT+8"】

指定时区：serverTimezone=GMT%2B8 
