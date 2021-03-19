<template>
  <div id="app">
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <!--
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    -->
    <router-view />
  </div>
</template>

<style lang="scss">
* {
  font-family: "Lato", sans-serif;
}
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  overflow-x: hidden;
}
.lightredbtn {
  font-weight: 500;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  font-size: 1.2em;
  text-align: center;
  margin-left: 2%;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-right: 30px;
  padding-left: 30px;
  background-color: #d62447;
  color: white;
  width: 60%;
  display: inline-block;
  white-space: nowrap;
  vertical-align: middle;
  white-space: normal;
  word-wrap: break-word;
  &:hover {
    color: white;
    background-color: #d62447;
    text-decoration: none;
    box-shadow: 0px 5px 5px rgba(2, 29, 44, 0.705);
    transform: translateY(-5px);
  }
}
.redbtn {
  font-weight: 500;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  font-size: 1.2em;
  text-align: center;
  margin-left: 2%;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-right: 30px;
  padding-left: 30px;
  background-color: #87132a;
  color: white;
  width: 60%;
  display: inline-block;
  white-space: nowrap;
  vertical-align: middle;
  white-space: normal;
  word-wrap: break-word;
  &:hover {
    color: white;
    background-color: #87132a;
    text-decoration: none;
    box-shadow: 0px 5px 5px rgba(2, 29, 44, 0.705);
    transform: translateY(-5px);
  }
}
.vuecal__event.japassou {
  opacity: 0.5;
}
.vuecal__event.reservada {
  border-radius: 25px;
  background-color: #13872e;
  margin: 5px 0px 5px 0px;
  border: 1px solid #0d7926;
  color: #fff;
  font-size: 0.9em;
}
.vuecal__event.naoreservada {
  border-radius: 25px;
  background-color: #d22346;
  margin: 5px 0px 5px 0px;
  border: 1px solid #be1235;
  color: #fff;
  font-size: 0.9em;
}
.vuecal--month-view .vuecal__cell,
.vuecal--week-view .vuecal__cell {
  height: 100px;
}
.vuecal__cell-date {
  color: #87132a;
}
.vuecal--month-view .vuecal__cell-content,
.vuecal--week-view .vuecal__cell-content {
  justify-content: center;
  height: 100%;
  align-items: center;
}
.vuecal--month-view .vuecal__no-event,
.vuecal--week-view .vuecal__no-event {
  display: none;
}
.vuecal__flex .vuecal__menu {
  background-color: #87132a;
}
.vuecal__flex .vuecal__menu button {
  border-bottom-color: #fff;
  color: #fff;
}
.vuecal__flex .vuecal__menu button.active {
  background-color: rgba(255, 255, 255, 0.15);
}
.vuecal__title-bar {
  background-color: #e2e2e2;
  color: black;
}
.vuecal__cell.today,
.vuecal__cell.current {
  background-color: #e2e2e2;
}
.vuecal:not(.vuecal--day-view) .vuecal__cell.selected {
  background-color: #e2e2e2;
}
.vuecal__cell.selected:before {
  background-color: transparent;
  border-color: transparent;
}
.vuecal {
  border-radius: 25px 25px 0px 0px;
}
#card {
  box-shadow: 3px 5px 5px rgba(80, 81, 82, 0.705);
}
#smallcard {
  box-shadow: 1px 1px 1px rgba(80, 81, 82, 0.705);
}
</style>
