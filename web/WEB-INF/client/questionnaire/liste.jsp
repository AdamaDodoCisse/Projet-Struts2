
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="titre" var="titre" value="Gestions des Utilisateurs "/>
<s:include value="../partials/header.jsp" />

<s:div class="container">
  <s:if test="%{questionnaireDAO.list().size() == 0 }">
      <div class="alert alert-info">
        <h1 style="text-align: center;">L'administrateur n'a pas encore crée de questionnaire pour cette page.</h1>
        <p class="text-info">
          Veuillez revenir plutard !!!
        </p>
      </div>
      <p style="text-align: center">
        <img src="/lib/Bootstrap-Clean-Dashboard/images/big_loading.gif" />
      </p>
  </s:if>
  <s:else>
    <s:div class="row">
      <s:iterator value="questionnaireDAO.list()">
        <s:div class="span4">
          <div class="well">
          <h3>
            <s:property value="libelle" />
          </h3>
          <hr/>
          <s:if test="attente">
            <p>Ce QCM est en attente de lancement !!</p>
          </s:if>
          <s:else>
            <p>
              Vous pouvez passer ce qcm si vous ne l'avez pas encore terminer !!
            </p>
          </s:else>
          <p class="text text-info">Une serie de <s:property value="nombreQuestion" /> question(s)</p>
         <s:form action="demarrer_qcm" namespace="/">
           <s:if test="attente">
             <s:if test="%{evaluationDAO.terminer(utilisateur.identifiant , identifiant)}%" >
               <s:submit value="Voir score" class="btn btn-warning btn-bg"/>
             </s:if>
             <s:else>
               <s:submit value="Passer le test" class="btn btn-success btn-bg" disabled="true"/>
             </s:else>
           </s:if>
           <s:else>
             <s:textfield value="%{identifiant}" type="hidden" name="questionnaire.identifiant" theme="simple"/>
             <s:if test="%{evaluationDAO.terminer(utilisateur.identifiant , identifiant)}%" >
               <s:submit value="Voir score" class="btn btn-warning btn-bg"/>
             </s:if>
             <s:else>
               <s:submit value="Passer le test" class="btn btn-success btn-bg"/>
             </s:else>

           </s:else>
         </s:form>
          </div>
        </s:div>
      </s:iterator>
    </s:div>
  </s:else>
</s:div>

<s:include value="../partials/footer.jsp"/>