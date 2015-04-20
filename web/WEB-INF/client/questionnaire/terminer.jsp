<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="titre" var="titre" value="Gestions des Utilisateurs "/>
<s:include value="../partials/header.jsp" />

<div class="container">
  <br/><br/> <br/>
  <div class="alert alert-info">
    <h1 style="text-align: center;">Felicitation vous venez de terminer le QCM  <strong><s:property value="questionnaire.libelle"/></strong>!!! </h1>
  </div>
  <s:if test="%{!evaluationDAO.terminer(questionnaire.identifiant)}">
    <h2 class="text-info">
      <em>Les autres participants n'ont pas encore finit veuillez revenir plutard. pour voir vos resultat <br/>
      <span id="message"></span> </em>
    </h2>
    <p style="text-align: center">
      <img src="/lib/Bootstrap-Clean-Dashboard/images/big_loading.gif" />
    </p>
  </s:if>
  <s:else>

  </s:else>
</div>
<script>
  var url = '<s:url action="information-participant" namespace="/ajax"><s:param name="questionnaire.identifiant"><s:property value="questionnaire.identifiant"/></s:param></s:url>';
  $.get(url , function(resultat)
  {
      $("#message").html(resultat.terminer + "<strong> sur </strong>" + resultat.participants + " ont terminé ce QCM ");
  });

</script>
<s:include value="../partials/footer.jsp"/>