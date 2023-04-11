<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center" dense>
      <v-col cols="12" sm="8" md="4" lg="4">
        <v-card>
          <v-card-text>
            <div class="text-center my-5">
              <h1 class="text-h2-front-weight-bold">Admin Login</h1>
            </div>
            <v-form>
              {{ email }}
              <v-text-field v-model="email" label="Enter your email" name="email" prepend-inner-icon="mdi-email"
                type="email" outlined></v-text-field>
              <v-text-field v-model="password" label="Enter your password" name="password" prepend-inner-icon="mdi-lock"
                type="password" outlined></v-text-field>
              <v-btn @click="goToAdminPage()" color="primary" x-large block dark>Login</v-btn>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script lang="ts" setup>
import router from '@/router';
import { ref } from 'vue';

const email = ref('')
const password = ref('')

function goToAdminPage() {
  router.push({ path: '/AdminPortal' });
}


function login() {
  if (!email.value) {
    console.error('No email')
  }
  if (!password.value) {
    console.error('No password')
  }
  console.log(email.value);
  console.log(password.value);
}
</script>
