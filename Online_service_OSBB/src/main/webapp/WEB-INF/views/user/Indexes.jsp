	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

		<sec:authorize access="isAuthenticated()">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<article>
                    <div class="col-md-2 pay-menu text-center">
                    <div class="row part-menu ">
                        <a href="/Receipts" class="col-md-12">Квитанції</a>
                    </div>
                    <div class="row part-menu active-part-menu">
                        <a href="/Indexes" class="active col-md-12">Показники</a>
                    </div>
                 </div>
              
                <div class="col-md-6 pay">
                    <div class="row ">
                        <div class="col-md-12">
                            <h3 class=" pay-title control-label">Ваші показники:</h3>
                            <p style="margin-top:5px; color:red; font-size:20px;
                            	 ;font-family: 'Times New Roman', Times, serif;
                            	  font-style:italic;" class="text-center">
                            	Щоб подати показники увійдіть як мешканець.	  
                            </p>
                 
                        </div>
                    </div>
                    <form:form  class="form-horizontal" action="/Indexes" method="POST" modelAttribute="indicators" >
                    <div class="input-group pay-form pay-border">
                        <label for="hot_w" class="" >Горяча вода</label>
                        <div class="row">
                            <div class="col-md-10">
                                <input type="text"  id="hot_w" disabled class="form-control pokaz-input"/>
                            </div>
                            <div class="col-md-2 pay-vymir" ><p>куб. м.</p></div>

                        </div>
                        <label for="cold_w" class="label_pokazy">Холодна вода</label>
                        <div class="row">
                            <div class="col-md-10">
                                <input type="text" id="cold_w"  disabled class="form-control pokaz-input"/>
                            </div>
                            <div class="col-md-2 pay-vymir" ><p>куб. м.</p></div>

                        </div>
                        <label for="opal" class="label_pokazy">Опалення</label>
                        <div class="row">
                            <div class="col-md-10">
                                <input type="text" id="opal" disabled class="form-control pokaz-input"/>
                            </div>
                            <div class="col-md-2 pay-vymir" ><p>ГКал</p></div>

                        </div>
                        <label for="date" class="label_pokazy"></label>
                        <div class="row">
                            
                            <div class="col-md-4">
                                <button type="button" class="btn btn-default pay-pokazy-submit" >Підтвердити</button>
                            </div>
                        </div>
                    </div>
                    </form:form>
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class=" pay-title control-label">Попередні подані показники</h3>
                        </div>
                    </div>
                    <div style="padding-left: 15px; margin-top: 15px;">
                        <div class="row table_pokazy_head">
                            <div class="col-md-3 text-center ">Показники на початок періоду</div>
                            <div class="col-md-3 text-center ">Показники на данний період</div>
                            <div class="col-md-3 text-center ">Дата внесення</div>
                            <div class="col-md-3 text-center ">Спожито</div>
                        </div>
                        <div class="row table_row ">
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">00.00</div>
                        </div>
                        <div class="row table_row ">
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                        </div>
                        <div class="row table_row ">
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                        </div>
                    </div>
                    
                    
                </div>
                <div class="col-md-4 pokazy_table">
                   <div class="row ">
                        <div class="col-md-12 pay-border-title ">
                            <h3 class=" pay-title control-label">Тарифи</h3>
                        </div>
                    </div>
                    <div class="row table-head">
                        <div class="col-md-6 text-center">Назва</div>
                        <div class="col-md-6 text-center">Тариф</div>
                    </div>
                    <c:forEach items="${tariffses}" var="tariffs">
                    <div class="row table_row">
                        <div class="col-md-7 ">${tariffs.name}</div>
                        <div class="col-md-5 text-center">${tariffs.price} грн.</div>
                    </div>
                    </c:forEach>
                </div>
            
       			</article>
			</sec:authorize>
		</sec:authorize>


	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_USER')">
			<article>
                    <div class="col-md-2 pay-menu text-center">
                    <div class="row part-menu ">
                        <a href="/Receipts" class="col-md-12">Квитанції</a>
                    </div>
                    <div class="row part-menu active-part-menu">
                        <a href="/Indexes" class="active col-md-12">Показники</a>
                    </div>
                 </div>
              
                <div class="col-md-6 pay">
                    <div class="row ">
                        <div class="col-md-12">
                            <h3 class=" pay-title control-label">Ваші показники</h3>
                            
                            
                        </div>
                    </div>
                    <form:form  class="form-horizontal" action="/Indexes" method="POST" modelAttribute="indicators" >
                    <div class="input-group pay-form pay-border">
                        <label for="hot_w" class="" >Горяча вода</label>
                        <div class="row">
                            <div class="col-md-10">
                            	<label for="hwater" class="enter-lable" style="color:red;"><form:errors path="hwater"/></label>
                                <form:input type="text" path="hwater" id="hot_w" class="form-control pokaz-input"/>
                            </div>
                            <div class="col-md-2 pay-vymir" ><p>куб. м.</p></div>

                        </div>
                        <label for="cold_w" class="label_pokazy">Холодна вода</label>
                        <div class="row">
                            <div class="col-md-10">
                            	<label for="cwater" class="enter-lable" style="color:red;"><form:errors path="cwater"/></label>
                                <form:input type="text" id="cold_w" path="cwater" class="form-control pokaz-input"/>
                            </div>
                            <div class="col-md-2 pay-vymir" ><p>куб. м.</p></div>

                        </div>
                        <label for="opal" class="label_pokazy">Опалення</label>
                        <div class="row">
                            <div class="col-md-10">
                            	<label for="heating" class="enter-lable" style="color:red;"><form:errors path="heating"/></label>
                                <form:input type="text" path="heating" id="opal" class="form-control pokaz-input"/>
                            </div>
                            <div class="col-md-2 pay-vymir" ><p>ГКал</p></div>

                        </div>
                        <label for="date" class="label_pokazy"></label>
                        <div class="row">
                            
                            <div class="col-md-4">
                                <button type="submit" class="btn btn-default pay-pokazy-submit" >Підтвердити</button>
                            </div>
                        </div>
                    </div>
                    </form:form>
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class=" pay-title control-label">Попередні подані показники</h3>
                        </div>
                    </div>
                    <div style="padding-left: 15px; margin-top: 15px;">
                        <div class="row table_pokazy_head">
                            <div class="col-md-3 text-center ">Показники на початок періоду</div>
                            <div class="col-md-3 text-center ">Показники на данний період</div>
                            <div class="col-md-3 text-center ">Дата внесення</div>
                            <div class="col-md-3 text-center ">Спожито</div>
                        </div>
                        <div class="row table_row ">
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">00.00</div>
                        </div>
                        <div class="row table_row ">
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                        </div>
                        <div class="row table_row ">
                            <div class="col-md-3 text-center">nazva</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                            <div class="col-md-3 text-center">00.00</div>
                        </div>
                    </div>
                    
                    
                </div>
                <div class="col-md-4 pokazy_table">
                   <div class="row ">
                        <div class="col-md-12 pay-border-title ">
                            <h3 class=" pay-title control-label">Тарифи</h3>
                        </div>
                    </div>
                    <div class="row table-head">
                        <div class="col-md-6 text-center">Назва</div>
                        <div class="col-md-6 text-center">Тариф</div>
                    </div>
                    <c:forEach items="${tariffses}" var="tariffs">
                    <div class="row table_row">
                        <div class="col-md-7 ">${tariffs.name}</div>
                        <div class="col-md-5 text-center">${tariffs.price} грн.</div>
                    </div>
                    </c:forEach>
                </div>
             </article>
          </sec:authorize>
       </sec:authorize>
