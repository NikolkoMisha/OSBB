<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<article>
			<div class="container-fluid">
				
                <div class="col-md-7">
                <c:forEach items="${infos}" var="info">
                    <div class="row">
                        <div class="col-md-12 contacts-contact">
                            <h1>Контактна інформація</h1>
                            <hr>
                            
	                            <p>Повна назва: ${info.fName}</p>
	                            <p>Адреса: ${info.address}</p>
	                            <p>Телефон: ${info.phoneOSBB}</p>
	                            <p>Графік прийому: ${info.workSchedule}</p>
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 contacts-map">
                          <img class="img-responsive" src="/images/osbbinfo/${info.id}.jpg?version=${info.version}" width="60%">
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <div class="col-md-5 "  >
                    <div class="row contact-pad" >
                        <div class="col-md-12 contacts-contact" style="padding-bottom: 50px;">
                            <h1>Контакти</h1>
                            <hr>
                            <div style="overflow-y:scroll;overflow-x:hidden; height:460px; margin-top:px">
                            <c:forEach items="${workerses}" var="workers">
                            <div class="row" >
                                <h3 class="">${workers.position}</h3>
                                <div class="col-md-7 contacts-content" >
                                    <h4 class="text-center">${workers.surname} ${workers.name} ${workers.fathername}</h4>
                                </div>
                                <div class="col-md-5 contacts-content1" >
                                    <h4 class="text-center">${workers.phoneWorker}</h4>
                                </div>
                            </div>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 contacts-message">
                    <h1>Зворотній зв'язок</h1>
                    <div class="row">
                        <div class="col-md-4">
                             <div class="form-group">
                                <input type="text" class="form-control" id="" placeholder="Ваше ім'я">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="" placeholder="Ваш телефон">
                            </div>
                        </div>
                        <div class="col-md-4">
                             <div class="form-group">
                                <input type="text" class="form-control" id="" placeholder="Номер квартитри">
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" id="" placeholder="Email">
                            </div>
                        </div>
                        <div class="col-md-4">
                             <div class="form-group">
                                 <textarea class="form-control" id="exampleTextarea" placeholder="Ваше питання?" rows="3"></textarea>
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-default btn-block">Надіслати повідомлення</button>
                            </div>
                        </div>
                    </div>
                </div>
				
			</div>
		</article>