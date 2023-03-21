<template>
  <router-view />
  <main>
  <v-app>
    <div class="background"></div>
    <v-main class="d-flex justify-center align-center">
      <v-col cols="10" lg="4" class="mx-auto">
        <v-card>
          <div class="text-center">
            <v-avatar size="100" color="indigo lighten-4">
              <v-icon size="40" color="white">mdi-account</v-icon>
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
              <v-btn color="indigo">
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

<script lang="ts" setup>
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
