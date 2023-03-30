<template>
 <v-adminSite>
    <v-main>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center" dense>
        <v-col cols="12" sm="8" md="4" lg="4">         
          <v-card elevation="0">
            <div class="text-center">
              <h1 class="mb-2">Login</h1>
            </div>
            <a href="https://sweng-AdminSiteLogin.com" name="Admin Site Login" title="Admin Site Login" target="_blank">
            </a>
            <v-card-text>
              <v-form>
                <v-text-field label="Enter your email" name="email" prepend-inner-icon="mdi-email" type="email" class="rounded-0" outlined></v-text-field>
                <v-text-field label="Enter your password" name="password" prepend-inner-icon="mdi-lock" type="password" class="rounded-0" outlined></v-text-field>
                <v-btn class="rounded-0" color="#000000" x-large block dark>Login</v-btn>
              </v-form>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
</v-main>
 </v-adminSite>
</template>

<script lang="ts">
export default {
name: 'Admin Site Login'
}
</script>

<style lang="css" scoped>
</style>