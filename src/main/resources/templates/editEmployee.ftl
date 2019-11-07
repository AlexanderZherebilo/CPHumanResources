<#import "parts/common.ftl" as c>

<@c.page "Редактирование личных данных">
    <#include "parts/navbar.ftl">
<div class="container-fluid my-2">
    <h4>Редактировать профиль</h4>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Фамилия:</label>
            <div class="col-sm-3">
                <input type="text" name="surname" class="form-control" value="${employee.passport.surname!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя:</label>
            <div class="col-sm-3">
                <input type="text" name="name" class="form-control" value="${employee.passport.name!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Отчество:</label>
            <div class="col-sm-3">
                <input type="text" name="lastname" class="form-control" value="${employee.passport.lastname!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата рождения:</label>
            <div class="col-sm-3">
                <input type="date" name="birthday" class="form-control" value="${birthday!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пол:</label>
            <div class="col-sm-3">
                <select name="gender" class="form-control">
                    <#list genders as gender>
                        <option value="${gender}" <#if gender == employee.passport.gender>selected="selected"</#if>>${gender}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Семейное положение:</label>
            <div class="col-sm-3">
                <select name="gender" class="form-control">
                    <#list marriges as marrige>
                        <option value="${marrige}" <#if marrige == employee.maritalStatus>selected="selected"</#if>>${marrige}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Адрес:</label>
            <div class="col-sm-3">
                <input type="text" name="address" class="form-control" value="${employee.address!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Мобильный телефон:</label>
            <div class="col-sm-3">
                <input type="text" name="telephone" class="form-control" value="${employee.telephone!''}" required/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</div>
</@c.page>