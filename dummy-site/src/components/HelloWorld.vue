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
            <v-avatar size="100" color="indigo lighten-4">
              <v-icon size="50" color="white">mdi-account</v-icon>
            </v-avatar>
            <h2 class="indigo--text">Pluggable Auth Module Login</h2>
          </div>
          <v-form>
            <v-card-text>
              <v-text-field
                      type="email"
                      label="Email"
                      outline dense color="blue"
                      autocomplete="false"
                      placeholder="Email"
                      prepend-inner-icon="mdi-account"
                      required
              />
              <v-switch label="Remember me" color="indigo"></v-switch>
            </v-card-text>
            <v-card-actions class="justify-center">
              <v-btn color="indigo" @click.prevent="submitForm">
                <span class="white--text px-8">SUBMIT</span>
              </v-btn>
            </v-card-actions>
          </v-form>
        </v-card>
      </v-col>
    </v-main>
  </v-app>
  </main>
</template>

<script lang="ts">
import axios from 'axios'

export default { 
  name: 'PostFormAxios',
    data(){
        return{
            form: {
                email: 'odoemele@tcd.ie',
                terms: false
            }
        }
    },
    methods:{
        submitForm(){
            axios.post('http://localhost:8080/login', this.form)
                 .then((res) => {
                     //Perform Success Action
                 })
                 .catch((error) => {
                     // error.response.status Check status code
                 }).finally(() => {
                     //Perform action in always
                 });
        }
    }
}
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