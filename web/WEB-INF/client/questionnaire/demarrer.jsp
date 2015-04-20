<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="titre" var="titre" value="Gestions des Utilisateurs "/>
<s:include value="../partials/header.jsp" />


<div class="container">


    <s:form action="demarrer_qcm" namespace="/" method="post">
        <s:textfield type="hidden" name="questionnaire.identifiant" value="%{questionnaire.identifiant}" theme="simple"/>
        <s:textfield type="hidden" name="abandon" value="1" theme="simple"/>
        <div class="row">
            <div class="span10">
                <div class="box">
                    <div class="box-header">

                        <h5>Evaluation</h5>
                    </div>
                    <div class="box-content collapse in">
                        <h2><s:property value="question.contexte"/></h2>
                        <s:iterator value="reponses" >
                            <div class="row">
                               <div class="span8">
                                   <s:property value="proposition"/>
                               </div>
                                <div class="span1">
                                    <s:if test="%{!vrai}">
                                        <s:textfield type="checkbox" class="faux" name="choix" value="%{identifiant}" theme="simple"/>
                                    </s:if>
                                    <s:else>
                                        <s:textfield type="checkbox" name="choix" value="%{identifiant}" theme="simple"/>
                                    </s:else>

                                </div>
                            </div>
                        </s:iterator>
                    </div>
                    <div class="box-footer">
                       <div class="btn-group">
                           <button type="submit" id="evaluer"class="btn btn-success"><i class="icon-ok"></i> Valider</button>
                       </div>
                    </div>
                </div>
            </div>
            <div class="span6">
                <div class="box">
                    <div class="box-header">

                        <h5>Panneau d'information</h5>
                    </div>
                    <div class="box-content collapse in">
                        <h2>QCM restantes <s:property value="%{evaluationDAO.questionRestante(utilisateur.identifiant,questionnaire.identifiant)}"/></h2>
                        <hr/>

                        <h3>Chronomètre</h3>
                        <p>Il vous reste : </p>
                        <h1 style="text-align: center"><span id="temps"><s:property value="questionnaire.duree"/></span> <span style="font-size: 10px">seconde(s)</span></h1>
                        <div class="box-footer">
                            <div class="alert-info alert" id="message"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
</div>
<script>
    $(function()
    {
        var temps = <s:property value="questionnaire.duree"/> ;
        var url = '<s:url action="information-participant" namespace="/ajax"><s:param name="questionnaire.identifiant"><s:property value="questionnaire.identifiant"/></s:param></s:url>';
        var cache = {};
        setInterval(function()
        {

            $.get(url , function(resultat)
            {
               if(cache != resultat)
               {
                   cache = resultat;
                   $("#message").html(resultat.terminer + "<strong> sur </strong>" + resultat.participants + " ont terminé ce QCM ");
               }

            });

            if(temps < 0)
            {
                $('.faux').click();
                $('#evaluer').click();
            }else{
                $('#temps').html(temps);
            }

            temps = temps - 1;
        },1000);
    });
</script>
<s:include value="../partials/footer.jsp"/>
