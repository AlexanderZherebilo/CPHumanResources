<#import "parts/common.ftl" as c>

<@c.page "Профиль сотрудника">
    <#include "parts/navbar.ftl">
    <div class="container my-4">
        <div class="row">
            <div class="col-md-3 card" style="width:300px">
                <#if currentEmployee.photo??>
                    <img src="/img/${currentEmployee.photo}" height="250px" width="250px" class="card-img-top">
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
            <div class="col-md-4 bg-light text-dark">
                <p><b>Пол:</b> ${currentEmployee.passport.gender}</p>
                <p><b>Дата рождения:</b> ${currentEmployee.passport.birthday}</p>
                <p><b>Семейное положение:</b> ${currentEmployee.maritalStatus}</p><hr>
                <p><b>Образование:</b> ${currentEmployee.education}</p>
                <p><b>Специальность:</b> ${currentEmployee.speciality}</p>
                <p><b>Квалификация:</b> ${currentEmployee.qualification}</p>
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
        </div>
    </div>
</@c.page>