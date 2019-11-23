<#import "parts/common.ftl" as c>

<@c.page "Выдача отпуска">
    <#include "parts/navbar.ftl">
<div class="container-fluid my-2">
    <h4>Выдача отпуска</h4>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Тип отпуска:</label>
            <div class="col-sm-3">
                <select name="type" class="form-control">
                    <#list types as type>
                        <option value="${type}">${type}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата начала отпуска:</label>
            <div class="col-sm-3">
                <input type="date" name="start" class="form-control" value="${start!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата окончания:</label>
            <div class="col-sm-3">
                <input type="date" name="finish" class="form-control" value="${finish!''}" required/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</div>
</@c.page>