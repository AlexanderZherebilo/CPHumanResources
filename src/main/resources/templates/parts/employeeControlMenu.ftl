<#include "security.ftl">

<nav class="navbar navbar-expand navbar-light bg-light">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#currentEmployeeMenu" aria-controls="currentEmployeeMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>
    <div class="collapse navbar-collapse" id="currentEmployeeMenu">
        <ul class="navbar-nav mr-auto flex-column">
            <div class="navbar-header">
                <a class="navbar-brand" href="">Меню управления</a>
            </div>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/employee/editEmployee">Личная информация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/employee/editLearning">Образование</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/employee/family/${currentEmployeeId}">Состав семьи</a>
            </li>
            </#if>
        </ul>
    </div>
</nav>