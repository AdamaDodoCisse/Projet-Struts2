<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
  <title><s:property value="titre"/></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="http://bootswatch.com/simplex/bootstrap.css" media="screen"/> -->
  <!-- <link rel="stylesheet" href="http://bootswatch.com/simplex/bootstrap.min.css"/> -->
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
      <a href="" class="brand"><i class="icon-leaf">Administration</i></a>
      <div id="app-nav-top-bar" class="nav-collapse">
        <ul class="nav">

          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Utilisateurs
              <b class="caret hidden-phone"></b>
            </a>
            <ul class="dropdown-menu">
              <li>
                <s:a action="ajouter_utilisateur">Inscrire</s:a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Questionnaire
              <b class="caret hidden-phone"></b>
            </a>
            <ul class="dropdown-menu">
              <li>
                <s:a action="ajouter_questionnaire">Gestion Questionnaire</s:a>
              </li>
              <li>
                <s:a action="ajouter_question">Gestion Question</s:a>
              </li>
              <li>
                <s:a action="ajouter_reponse">Gestion Reponse</s:a>
              </li>
            </ul>
          </li>

        </ul>
        <ul class="nav pull-right">
          <li>
            <s:a action="deconnection" namespace="/" theme="simple">Se deconnecter</s:a>
          </li>

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
              <h3>Administration<br>
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