<#include "security.ftl">

<nav class="navbar navbar-expand navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#employeeAdminMenu" aria-controls="employeeAdminMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="employeeAdminMenu">
        <ul class="navbar-nav mr-auto flex-column">
            <div class="navbar-header">
                <a class="navbar-brand" href="">Меню назначений</a>
            </div>
            <li class="nav-item">
                <a class="nav-link" href="/employee/employeeProfile/setSalary/${currentEmployee.id}">Назначить зарплату</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">Выдать отпуск</a>
            </li>
        </ul>
    </div>
</nav>