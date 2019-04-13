<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
		
		 <div class="container-fluid">
                <div class="text-center col-md-offset-3 col-md-6">
                    <div class="enter-main">
                        <h3>Реєстрація</h3>
                        <hr>
                        <form:form  action="/registration" method="POST" class="input-group enter-main-group" modelAttribute="user">
                            <div class="input-group" style="width:100%;">
                            	<div class="col-md-offset-3 col-md-9 text-left">
                                    <label for="email" class="enter-lable" style="color:red;"><form:errors path="email"/></label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <label for="name_enter" class="enter-lable">Email</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="example@domain.com" class="form-control" name="email" id="email"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                            <div class="col-md-offset-3 col-md-9 text-left">
                                    <label for="surname" class="enter-lable" style="color:red;"><form:errors path="surname"/></label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable">Прізвище</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="surname" class="form-control" name="surname" id="surname"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                <div class="col-md-offset-3 col-md-9 text-left">
                                    <label for="name" class="enter-lable" style="color:red;"><form:errors path="name"/></label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable">Ім'я</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="name" class="form-control" name="name" id="name"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                <div class="col-md-offset-3 col-md-9 text-left">
                                    
                                </div>
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable">По-батькові</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="lastname" class="form-control" name="lastname" id="lastname"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable">Квартира</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="apartment" class="form-control" name="apartment" id="apartment"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                              
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable">Телефон</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="+38(0**) *** ** **" class="form-control" name="phone" id="phone"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                <div class="col-md-offset-3 col-md-9 text-left">
                                    <label for="login" class="enter-lable" style="color:red;"><form:errors path="login"/></label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable">Логін</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="login" class="form-control" name="login" id="login"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                <div class="col-md-offset-3 col-md-9 text-left">
                                    <label for="password" class="enter-lable" style="color:red;"><form:errors path="password"/></label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable" >Пароль</label>
                                </div>
                                <div class="col-md-9">
                                    <input  placeholder="password" class="form-control" type="password" name="password" id="password"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                <div class="col-md-offset-4 col-md-8 text-left">
                                    <label for="secret" class="enter-lable"><form:errors path="secret"/></label>
                                </div>
                                <div class="col-md-4 text-left">
                                    <label for="pass_enter" class="enter-lable">Пароль ОСББ</label>
                                </div>
                                <div class="col-md-8">
                                    <input  placeholder="password OSBB" type="password" class="form-control" name="secret" id="secret"/>
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%; padding: 0 15px;">
                                <button type="submit" class="btn btn-default pay-pokazy-submit" >Зареєструвати</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
		
		
  		<!--  	<div class="form-group">
				<label for="email" class="col-sm-offset-2 col-sm-10" style="color:red;"><form:errors path="email"/></label>
			</div>
			<div class="form-group">
			<label for="email" class="col-sm-2 control-label" style="color:#000">Email</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="example@domain.com" class="form-control" name="email" id="email"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="name" class="col-sm-offset-2 col-sm-10" style="color:red;"><form:errors path="name"/></label>
			</div>
			<div class="form-group">
			<label for="name" class="col-sm-2 control-label" style="color:#000">Ім'я</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="name" class="form-control" name="name" id="name"/>
    			</div>
  			</div>
    		<div class="form-group">
				<label for="surname" class="col-sm-offset-2 col-sm-10" style="color:red;"><form:errors path="surname"/></label>
			</div>
			<div class="form-group">
    			<label for="surname" class="col-sm-2 control-label" style="color:#000">Прізвище</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="surname" class="form-control" name="surname" id="surname"/>
    			</div>
    		</div>
    		<div class="form-group">
    			<label for="apartment" class="col-sm-2 control-label" style="color:#000">Квартира</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="apartment" class="form-control" name="apartment" id="apartment"/>
    			</div>
    		</div>
    		<div class="form-group">
    			<label for="phone" class="col-sm-2 control-label" style="color:#000">Телефон</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="phone" class="form-control" name="phone" id="phone"/>
    			</div>
    		</div>
  			<div class="form-group">
				<label for="login" class="col-sm-offset-2 col-sm-10" style="color:red;"><form:errors path="login"/></label>
			</div>
  			<div class="form-group ">
  			<label for="login" class="col-sm-2 control-label" style="color:#000">Логін</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="login" class="form-control" name="login" id="login"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="secret" class="col-sm-offset-2 col-sm-10" style="color:red;"><form:errors path="secret"/></label>
			</div>
  			<div class="form-group ">
  			<label for="secret" class="col-sm-2 control-label" style="color:#000">Слово</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="secret" class="form-control" name="secret" id="secret"/>
    			</div>
  			</div>
  		 	<div class="form-group">
				<label for="password" class="col-sm-offset-2 col-sm-10" style="color:red;"><form:errors path="password"/></label>
			</div>
			<div class="form-group">
    			<label for="password" class="col-sm-2 control-label" style="color:#000">Пароль</label>
    			<div class="col-sm-4">
      				<input class="backlight" placeholder="password" class="form-control" type="password" name="password" id="password"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
      				<button type="submit" class="btn btn-info">Зареєструвати</button>
    			</div>
  			</div>  
  			-->
		
	</div>
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>