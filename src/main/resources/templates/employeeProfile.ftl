<#import "parts/common.ftl" as c>

<@c.page "Профиль сотрудника">
    <#include "parts/navbar.ftl">
    <div class="row">
    <div class="col-md-2">
    <#include "parts/employeeControlMenu.ftl">
    </div>
    <div class="container my-3 col-md-10">
        <div class="row">
            <div class="col-md-3 card" style="width:300px">
                <#if currentEmployee.photo??>
                    <img src="/img/${currentEmployee.photo}" height="250px" width="200px" class="card-img-top">
                </#if>
                <#if !currentEmployee.photo??>
                    <#switch currentEmployee.passport.gender>
                        <#case "Мужской"> <img src="/img/Male.jpg" height="250px" width="250px" class="card-img-top"><#break>
                        <#case "Женский"> <img src="/img/Female.jpg" height="250px" width="250px" class="card-img-top"><#break>
                    </#switch>
                </#if>
                <div class="card-body">
                    <h4 class="card-title text-center">${currentEmployee.passport.surname} ${currentEmployee.passport.name} ${currentEmployee.passport.lastname}</h4>
                </div>
            </div>
            <div class="col-md-3 bg-light text-dark">
                <p><b>Дата рождения:</b> ${currentEmployee.passport.birthday}</p>
                <p><b>Семейное положение:</b> ${currentEmployee.maritalStatus}</p><hr>
                <p><b>Образование:</b> ${currentEmployee.education}</p>
                <a class="btn btn-primary" data-toggle="collapse" href="#privateInfo" role="button" aria-expanded="false" aria-controls="privateInfo">
                    Дополнительно
                </a><br>
                <div class="collapse" id="privateInfo">
                    <p><b>Табельный номер:</b> <span class="text-primary">${currentEmployee.personnelNumber}</span></p>
                    <p><b>Пенсионный код:</b> <span class="text-primary">${currentEmployee.retirementCode}</span></p>
                    <p><b>Адрес проживания:</b> <span class="text-primary">${currentEmployee.address}</span></p>
                    <p><b>Телефон:</b> <span class="text-primary">${currentEmployee.telephone}</span></p>
                </div>
            </div>
            <#if currentEmployee.learning??>
            <div class="col-md-4 bg-warning">
                <h2 class="text-center">Образование</h2>
                <p><b>Учреждение образования:</b> <span class="text-dark" title="${currentEmployee.getLearning().institution}">
                    ${currentEmployee.getLearning().getShortInst()}</span></p>
                <p><b>Форма обучения:</b> <span class="text-dark">${currentEmployee.learning.form}</span></p>
                <p><b>Факультет:</b> <span class="text-dark">${currentEmployee.learning.faculty}</span></p>
                <p><b>Специальность:</b> <span class="text-dark">${currentEmployee.learning.speciality}</span></p>
                <p><b>Квалификация:</b> <span class="text-dark">${currentEmployee.learning.qualification}</span></p>
                <p><b>Дата начала обучения:</b> <span class="text-dark">${currentEmployee.learning.start}</span></p>
                <p><b>Дата окончания обучения:</b> <span class="text-dark">${currentEmployee.learning.finish}</span></p>
            </div>
            </#if>
        </div>
        <div class="row">
        <#if currentEmployee.salary??>
            <div class="col-md-5 my-2 bg-success">
                <h2 class="text-center">Заработная плата</h2>
                <p><b>Величина зарплаты: </b>${currentEmployee.salary.value}  ${currentEmployee.salary.currency}</p>
                <p><b>Начало действия: </b>${currentEmployee.salary.start}</p>
                <p><b>Номер указа: </b>${currentEmployee.salary.orderNumber}</p>
                <p><b>Дата указа: </b>${currentEmployee.salary.dateOfOrder}</p>
            </div>
        </#if>
            <#if currentEmployee.vacation??>
                <div class="col-md-5 my-2 mx-2 bg-danger">
                    <h2 class="text-center">Сотрудник в отпуске</h2>
                    <p><b>Дата начала: </b>${currentEmployee.vacation.start}</p>
                    <p><b>Дата окончания: </b>${currentEmployee.vacation.finish}</p>
                </div>
            </#if>
        </div>
        <#if currentEmployee.hasRelatives() = true>
        <h3 class="text-center">Члены семьи</h3>
        <div class="row">
        <#list currentEmployee.getMembers() as member>
        <div class="col-md-4">
            <div class="card p-1 bg-light">
                <b><i>${member.relation}</i></b>
                    <span class="text-dark">${member.surname} ${member.name} ${member.lastname}</span>
                <div class="my-1">
                    <p><b>Дата рождения:</b> ${member.birthday}</p>
                    <p><b>Адрес проживания:</b> ${member.address}</p>
                    <p><b>Место работы/учёбы:</b> ${member.workPlace}</p>
                </div>
            </div>
        </div>
        </#list>
        </#if>
        </div>
    </div>
    </div>
</@c.page>