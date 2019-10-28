<#import "parts/common.ftl" as c>

<@c.page "Профиль сотрудника">
    <#include "parts/navbar.ftl">
    <div class="container my-4">
        <div class="row">
            <div class="col-md-3 card" style="width:300px">
                <img src="/img/${currentEmployee.photo}" height="250px" width="250px" class="card-img-top">
                <div class="card-body">
                    <h4 class="card-title text-center">${currentEmployee.surname} ${currentEmployee.name} ${currentEmployee.lastname}</h4>
                </div>
            </div>
            <div class="col-md-4 bg-light text-dark">
                <p><b>Пол:</b> ${currentEmployee.gender}</p>
                <p><b>Дата рождения:</b> ${currentEmployee.birthday}</p>
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