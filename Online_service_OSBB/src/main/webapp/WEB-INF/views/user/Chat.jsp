<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	 <article>
            <div class="container-fluid">
                <div class="col-md-offset-2 col-md-8">
                    <div class="bord-chat">
                    	<div style="overflow-y:scroll; height:400px;">
                         <c:forEach items="${messages}" var="message">
                         	
                         
							<div class="chat_row" style="overflow-x:hidden">
	                            <div class="row">
	                                <div class="col-md-offset-1 col-md-11 chat_name" style="margin-bottom:10px;">
	                                   <p>${message.user}</p>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-offset-2 col-md-8 chat_text">
	                                    <p class="col-md-8">${message.message}
		                                    <c:if test="${messages == null}">
		                                    	Тут буде відображатись історія повідомлень
		                                    </c:if>
	                                    </p>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-offset-1 col-md-9">
	                                    <hr>
	                                </div>
	                                <div class="col-md-1 text-right chat_data">
	                                    <div style="line-height:40px;" title="${message.date} ${message.month} ${message.year}р.  ${message.hour}:${message.minutes}:${message.seconds}" >${message.hour}:${message.minutes}</div>
	                                </div>
	                            </div>
                        	</div>
                        	
						</c:forEach>
						</div>
                        


                       <form:form class="form-horizontal" action="/Chat" method="POST" modelAttribute="message" enctype="multipart/form-data">
                            <div class="row chat_row" style="margin-bottom:15px;">
                                <div class="col-md-offset-1 col-md-10 chat_mess">
                                    <form:textarea style="border-radius:0" type="text" class="form-control" path="message" id="message" rows="3"/>
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-md-offset-7 col-md-4 text-right chat_but">
                                    <button type="submit" class="form-control btn btn-primary" style="margin-bottom:15px;" >Надіслати</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </article>


		<!-- 	<form:form class="form-horizontal" action="/Chat" method="POST" modelAttribute="message" enctype="multipart/form-data">
					
					<div class="form-group">
    					
    					<label for="message" class="col-sm-2 control-label" style="color:#fff">Текст</label>
    					<div class="col-sm-10">
      						<form:textarea type="text" class="form-control" path="message" id="message" rows="3"/>
    					</div>
  					</div>
  					<div class="form-group">
  						
		  					<label for="file" class="col-sm-2 control-label" style="color:#fff" >Image</label>
    					<div class="col-sm-8">
      						<input name="file" id="file" type="file" style="color:red">
    					</div>
		    			
	    			</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-info">Create</button>
    					</div>
  					</div>
				</form:form>
				
				 <c:forEach items="${messages}" var="message">
							<div class="chat_row">
                            <div class="row">
                                <div class="col-md-offset-1 col-md-11" style="margin-bottom:10px;">
                                   <p>Голопупенко Евген-ОРест кв.103</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-offset-2 col-md-8 chat_text">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse .</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-offset-1 col-md-8">
                                    <hr>
                                </div>
                                <div class="col-md-2 text-right chat_data">
                                    <div style="line-height:40px;">11:30 21.01.2017</div>
                                </div>
                            </div>
                        </div>
				</c:forEach>-->
<script>
		$(document).ready(function() {
		$('div').scrollTop(9999999999999999999999999999999999);
		});
</script>