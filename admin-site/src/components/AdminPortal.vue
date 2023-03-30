<template>
  <v-container class="fill-height">
    <v-responsive class="d-flex text-center fill-height">
      <v-row class="d-flex align-center justify-center">
        <v-col class="text-h2 text-center font-weight-bold text-decoration-underline">Admin Portal</v-col>
        <v-col cols="auto">
        <v-btn class="text-center font-weight-normal text-decoration-underline">Log Out</v-btn>
        </v-col>
      </v-row>

      <ul></ul>
      <ul></ul>

      <v-row class="d-flex align-center justify-center">
        <v-col class="text-h3 text-left font-weight-normal text-decoration-underline">
            Client List:
        </v-col>
        <v-col class="text-right">
          <v-btn color="green"
                  size="large"
                  target="_blank"
                  
          >
                   Register & Add Site
        </v-btn>
        </v-col>  
      </v-row>
      <table>
        <thead>
          <tr>
            <th class="w-40">Name</th>
            <th class="w-40">URL</th>
            <th class="w-40">Callback Url</th>
            <th class="w-40">Success Url</th>
            <th class="w-40">Error Url</th>
            <th class="w-40">Site ID</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white;"
                />
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white;"
                />
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white;"
                />
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white;"
                />
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white;"
                />
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white;"
                />
            </td>
          </tr>
        </tbody>
    </table>
      
      <div class="py-14" />
    </v-responsive>
  </v-container>
</template>

<script lang="ts" setup>
//
</script>

<script lang="ts">

  import {ref} from '@vue/reactivity'

  export default{
    data(){
    
      return {
      }
     
      const rows = ref([] as any)
      function addRow(){
      rows.value.push([
        {
          "Name":"",
          "URL":"",
          "Callback Url":"",
          "Success Url":"",
          "Error Url":"",
          "Site ID":"",
        },
      ]);
      console.log(rows.value);
      } return{
        rows, 
        addRow
      }      
    }
  }
  
</script>

<style scoped>
button[type="Register & Add Site"] {
  display: block;
  width: 100%;
  padding: 10px;
  font-size: 100%;
  border: none;
  border-radius: 5px;
  background-color: green;
  color: green;
}
</style>