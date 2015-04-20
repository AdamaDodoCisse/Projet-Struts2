
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="titre" value="Gestion des Questions"/>
<s:include value="../partials/header.jsp"/>

<s:div class="container">
  <h1>Gestionnaire de QCM</h1>
  <hr/>
  <s:div class="row">
    <s:div class="span6">
      <s:div class="well">
        <s:form action="ajouter_questionnaire" method="post">
          <s:div class="control-group">
            <label class="control-label">Libelle :</label>
            <s:textfield type="" name="questionnaire.libelle" required="true" value="%{questionnaire.libelle}" class="span4" theme="simple"/>
          </s:div>

          <s:div class="control-group">
            <label >Duree par question en seconde(s) :</label>
            <s:textfield type="numeric" name="questionnaire.duree" required="true" value="%{questionnaire.duree}" class="span4" theme="simple"/>
          </s:div>

          <s:div class="control-group">
            <label class="control-label">Nombre question :</label>
            <s:textfield type="numeric" name="questionnaire.nombreQuestion" required="true" class="span4" value="%{questionnaire.nombreQuestion}" theme="simple"/>

          </s:div>

          <s:div class="control-group">
            <label class="control-label">Mettre en Attente :</label>
            <s:checkbox name="questionnaire.attente" class="checkbox" theme="simple"/>
          </s:div>

          <hr/>
          <s:div class="control-group">
            <button class="btn btn-success">
              Ajouter <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"> </span></button>
          </s:div>
        </s:form>
      </s:div>
    </s:div>
    <s:div class="span10">
    <div class="well">
      <div class="panel panel-info">
        <div class="panel-heading">
          <h3 class="panel-title">Liste des Questionnaires</h3>
        </div>
        <div class="panel-body">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>Identifiant</th>
              <th>Libelle</th>
              <th>Etat</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="questionnaireDAO.list()">
              <tr>
                <td> <s:property value="identifiant" /></td>
                <td> <s:property value="libelle" /></td>
                <td>
                  <s:if test="attente">
                    <span class="text text-danger">Mise en attente</span>
                  </s:if>
                  <s:else>
                    <span class="text text-success">Mise en ligne</span>
                  </s:else>
                </td>
                <td>
                <s:form action="supprimer_questionnaire" method="post">
                  <s:textfield type="hidden" name="questionnaire.identifiant" value="%{identifiant}" theme="simple"/>
                  <button class="btn btn-primary">
                    Supprimer <span class="glyphicon glyphicon-remove" aria-hidden="true">  </span></button>
                </s:form>
              </td>
                <td>
                <s:if test="attente">
                  <s:form action="demarrer_questionnaire" method="post" theme="simple">
                    <s:textfield type="hidden" name="questionnaire.identifiant" value="%{identifiant}" theme="simple" />
                    <button class="btn btn-success">
                       Lancer <span class="glyphicon glyphicon-ok" aria-hidden="true"> </span></button>
                  </s:form>
                </s:if>
                <s:else>
                  <s:form action="stopper_questionnaire" method="post" theme="simple">
                    <s:textfield type="hidden" name="questionnaire.identifiant" value="%{identifiant}" theme="simple"/>
                    <button class="btn btn-danger">
                       Arreter <span class="glyphicon glyphicon-stop" aria-hidden="true"> </span></button>
                  </s:form>
                </s:else>
                </td>
              </tr>
            </s:iterator>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    </s:div>
  </s:div>
</s:div>

<s:include value="../partials/footer.jsp"/>