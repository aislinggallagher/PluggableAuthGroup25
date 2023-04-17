<template>
  <router-view /> 
              <nav>
                <div class="logo">Pluggable Website</div>
                    <div class="li"><a href="#">HOME</a></div>
                    <div class="li"><a href="#">ABOUT</a></div>
                    <div class="li"><a href="#">SERVICE</a></div>
                    <div class="li"><a href="#">CONTACT</a></div>
              </nav>
  <main>
  <v-app>
    <div class="background"></div>
    <v-main class="d-flex justify-center align-center">
      <v-col cols="7" lg="4" class="mx-auto">
        <v-card>
          <div class="text-center">
            <p v-if=checkCookie()>
              <h2 class="indigo--text">Thank you for loging in!</h2>
            </p>
            <p v-else>
              <h2 class="indigo--text">Pleas log in at: <a href="http://localhost:3000/">http://localhost:3000/</a></h2>
            </p>
          </div>
        </v-card>
      </v-col>
    </v-main>
  </v-app>
  </main>
</template>

<script lang="ts">
export default {
  methods: {
    checkCookie() {
      var JWTCookie = this.$cookies.get("Login_JWT");
      if(JWTCookie != null) {
          return true;
      }
      else{
        return false;
      }
    }
  },
};
</script>

<style>
 .background {
background-image: url(./assets/1.jpg) !important;
height: 100%;
width: 100%;
display: block;
position: absolute;
top: 0;
background-size: cover
} 
</style>


<style>
nav{
    background-color: #494646;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

nav .logo{
    color: #ff7200;
    font-size: 35px;
    font-family: Arial;
    padding-left: 10px;
    float: left;
    padding-top: 10px;
}

nav .li{
    color: #fff;
    padding: 10px 20px;
    position: relative;
    text-align: center;
    border-bottom: 3px solid transparent;
    display: flex;
    transition: 0.4s;
}

nav .li a{
    text-decoration: none;
    color: #fff;
    font-family: Arial;
    font-weight: bold;
    transition: 0.4s ease-in-out;
}

nav .li.active,
nav .li:hover {
  border-bottom-color: #7faeeb;
  transition: 0.4s ease-in-out;
}

nav .li a:hover{
    color: #40B5AD;
    text-decoration: none;
    transition: 0.4s ease-in-out;
}

</style>