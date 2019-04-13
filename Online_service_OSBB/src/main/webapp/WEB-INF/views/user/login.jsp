<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

			
					 <div class="container-fluid">
                <div class="text-center col-md-offset-3 col-md-6">
                    <div class="enter-main">
                        <h3>Увійти в особистий кабінет</h3>
                        <hr>
                        <form:form action="/login" method="POST" class="input-group enter-main-group" >
                            <div class="input-group" style="width:100%;">
                                <div class="col-md-3 text-left">
                                    <label for="name_enter" class="enter-lable">Логін</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="login" placeholder="Ваш логін" id="login">
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                <div class="col-md-3 text-left">
                                    <label for="pass_enter" class="enter-lable">Пароль</label>
                                </div>
                                <div class="col-md-9">
                                    <input placeholder="password" class="form-control" type="password" name="password" id="password">
                                </div>
                            </div>
                            <div class="input-group enter-group" style="width:100%; padding: 0 15px;">
                                <button type="submit" class="btn btn-default pay-pokazy-submit" >Увійти</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
			
			
			
			
			
			<!--
					 <div class="input-group" style="width:100%;">
                                <div class="col-md-3 text-right">
                                    <label for="login" class="enter-lable">Логін</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="login" placeholder="Ваш логін" id="login">
                                </div>
                            </div>
                            
                            <div class="input-group enter-group" style="width:100%;">
                                <div class="col-md-3 text-right">
                                    <label for="pass_enter" class="enter-lable">Пароль</label>
                                </div>
                                <div class="col-md-9">
                                    <input placeholder="password" class="form-control" type="password" name="password" id="password">
                                </div>
                            </div>
                            <div class="input-group enter-group" style="width:100%;">
                                <button type="submit" class="btn btn-default pay-pokazy-submit" >Увійти</button>
                            </div>
	  -			<div class="form-group">
	    		<!--  	<label for="login" class="col-sm-2 control-label" style="color:#fff">Login</label>
	    			<div class="col-sm-4">
	      				<input class="backlight" class="form-control" name="login" id="login" placeholder="login">
	    			</div>
	  			</div>
				<div class="form-group">
	    		<!--  	<label for="password" class="col-sm-2 control-label" style="color:#fff">Password</label>
	    			<div class="col-sm-4">
	      				<input class="backlight" placeholder="password" class="form-control" type="password" name="password" id="password">
	    			</div>
	  			</div>
	  			<div class="form-group">
	  				<div class=" col-sm-10">
	  					<div class="checkbox">
	  						<label style="color:#fff">
	  							<input name="remember-me" type="checkbox" > Remember me
	  						</label>
	  					</div>
	  				</div>
	  			</div>
	  			<div class="form-group">
	    			<div class="col-sm-10">
	      				<button type="submit" class="btn btn-info">Sign in</button>
	    			</div>
	  			</div> -->

