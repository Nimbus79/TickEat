<template>
  <div class="flags">
    <b-container class="bv-example-row d-none d-lg-block">
      <b-row>
        <b-col md="1" offset-md="11">
          <img id="flag-left" src="../assets/pt.png" width="40%" />
          <img id="flag-right" src="../assets/en.png" width="40%" />
        </b-col>
      </b-row>
    </b-container>

    <b-container class="bv-example-row d-none d-md-block d-lg-none">
      <b-row>
        <b-col md="2" offset-md="10">
          <img id="flag-left" src="../assets/pt.png" width="30%" />
          <img id="flag-right" src="../assets/en.png" width="30%" />
        </b-col>
      </b-row>
    </b-container>

    <b-container class="bv-example-row d-none d-sm-block d-md-none">
      <b-row>
        <b-col sm="2" offset-sm="10">
          <img id="flag-left" src="../assets/pt.png" width="30%" />
          <img id="flag-right" src="../assets/en.png" width="30%" />
        </b-col>
      </b-row>
    </b-container>

    <b-container class="bv-example-row d-block d-sm-none">
      <b-row>
        <b-col cols="3" offset="9">
          <img id="flag-left" src="../assets/pt.png" width="40%" />
          <img id="flag-right" src="../assets/en.png" width="40%" />
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {};
</script>

<style>
.flags {
  float: right;
}

#flag-left {
  margin: 0px 10px 0px 0px;
}

#flag-rigth {
  margin: 0px 0px 0px 10px;
}
</style>