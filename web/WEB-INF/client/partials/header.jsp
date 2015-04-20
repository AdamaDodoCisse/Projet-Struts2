
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>
        <s:if test="titre">
            <s:property value="titre" />
        </s:if>
        <s:else>
            Application de gestion de QCM
        </s:else>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="layout" content="main"/>

    <script type="text/javascript" src="http://www.google.com/jsapi"></script>

    <script src="../../../lib/Bootstrap-Clean-Dashboard/js/jquery/jquery-1.8.2.min.js" type="text/javascript" ></script>
    <link href="../../../lib/Bootstrap-Clean-Dashboard/css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />
    <link rel="stylesheet" href="../../../lib/Bootstrap-Clean-Dashboard/css/customize-template.css">

    <style>
        #body-content { padding-top: 40px;}
    </style>
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button class="btn btn-navbar" data-toggle="collapse" data-target="#app-nav-top-bar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="" class="brand"><i class="icon-leaf"> Application QCM</i></a>
            <div id="app-nav-top-bar" class="nav-collapse">
                <ul class="nav">
                    <li>
                        <a href="">Accueil</a>
                    </li>

                    <li>
                        <s:a action="ajouter_utilisateur" namespace="/admin" theme="simple">Adminstration</s:a>
                    </li>

                    <s:if test="utilisateur">

                            <li>
                                <s:a action="liste_questionnaire"  namespace="/">Liste Questionnaire</s:a>
                            </li>
                            <li>
                                <a href="#">Score</a>
                            </li>
                    </s:if>

                </ul>

                    <ul class="nav pull-right">
                        <s:if test="utilisateur">
                            <li>
                               <a href="#"> <i class="icon-user"></i> <s:property value="utilisateur.nom"/></a>
                            </li>
                            <li>
                                <s:a action="deconnection" namespace="/">Se deconnecter</s:a>
                            </li>
                        </s:if>
                        <s:else>
                            <li>
                                <s:a action="connection" namespace="/">Se connecter</s:a>
                            </li>
                        </s:else>
                    </ul>


            </div>
        </div>
    </div>
</div>
<div id="body-container">
    <div id="body-content">
                <!--
                    <div class="body-nav body-nav-vertical body-nav-fixed">
                      <div class="container">
                        <ul>
                          <li>
                            <a href="#">
                              <i class="icon-dashboard icon-large"></i> Dashboard
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <i class="icon-calendar icon-large"></i> Schedule
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <i class="icon-map-marker icon-large"></i> Map It
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <i class="icon-tasks icon-large"></i> Widgets
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <i class="icon-cogs icon-large"></i> Settings
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <i class="icon-list-alt icon-large"></i> Forms
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <i class="icon-bar-chart icon-large"></i> Charts
                            </a>
                          </li>
                        </ul>
                      </div>
                    </div>
                -->

                <section class="nav nav-page">
                    <div class="container">
                        <div class="row">
                            <div class="span7">
                                <header class="page-header">
                                    <h3>Etudiant <br>
                                        <small>Gestionnaire de Questionnaire</small>
                                    </h3>
                                </header>
                            </div>
                            <div class="page-nav-options">
                                <div class="span9">
                                    <ul class="nav nav-pills">
                                        <li>
                                        </li>
                                    </ul>
                                    <ul class="nav nav-tabs">
                                        <li>
                                            <a href="#"><i class="icon-home"></i>Accueil</a>
                                        </li>
                                        <li>
                                            <s:a action="liste_questionnaire" namespace="/" theme="simple">
                                                <i class="icon-list"></i> Liste Questionnaire</s:a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>