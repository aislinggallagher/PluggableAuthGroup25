<template>
  <!---<div class="container">
  <img src="C:\Users\amydo\Downloads\login.jpg" alt="Login image">-->
  <div class="login">
    <div style="display: flex; justify-content: center; align-items: center; height: 10vh;">
  <h1>Admin-site Login</h1>
    </div>
    <form>
      <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control" id="email" v-model="email" placeholder="Enter email">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" v-model="password" placeholder="Enter password">
      </div>
      <button type="submit" class="btn btn-primary" @click.prevent="submit">
  <span>Login</span>
  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 30 30" 
    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
    stroke-linejoin="round" class="feather feather-log-in" id="IconChangeColor"
    style="position: relative; top: 6.5px; margin-left: 5px;">
    <path d="M15 3h4a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-4" id="mainIconPathAttribute"></path>
    <polyline points="10 17 15 12 10 7"></polyline>
    <line x1="15" y1="12" x2="3" y2="12"></line>
  </svg>
</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password:"",
    };
  },
  methods: {
    submit() {
      // perform login logic
    }
  }
};
</script>

<style scoped>
.login {
  max-width: 400px;
  margin-left: auto;
  margin-right: 423px;
  margin-top: 125px;
  margin-bottom: auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
  background-color: #fff;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="email"]{
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

input[type="password"]{
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

button[type="submit"] {
  display: block;
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  background-color: #007bff;
  color: #fff;
}
</style>
