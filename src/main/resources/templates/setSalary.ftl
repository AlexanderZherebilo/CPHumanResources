<#import "parts/common.ftl" as c>

<@c.page "Установка зарплаты">
    <#include "parts/navbar.ftl">
<div class="container-fluid my-2">
    <h4>Назначение заработной платы</h4>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Тип заработной платы:</label>
            <div class="col-sm-3">
                <select name="type" class="form-control">
                    <#list types as type>
                        <option value="${type}" <#if currentType?? && type == currentType>selected="selected"</#if>>${type}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Валюта:</label>
            <div class="col-sm-3">
                <select name="currency" class="form-control">
                    <#list currencies as currency>
                        <option value="${currency}" <#if currentCur?? && currency == currentCur>selected="selected"</#if>>${currency}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Сумма:</label>
            <div class="col-sm-3">
                <input type="text" name="value" pattern="^[0-9]+$" title="Используйте только цифры" class="form-control" value="${value!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата вступления в силу:</label>
            <div class="col-sm-3">
                <input type="date" name="start" class="form-control" value="${start!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата указа:</label>
            <div class="col-sm-3">
                <input type="date" name="dateOfOrder" class="form-control" value="${dateOfOrder!''}" required/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</div>
</@c.page>