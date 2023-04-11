<template>
  <v-container fluid class="fill-height">
    <v-responsive class="d-flex text-center fill-height">
      <v-row class="d-flex align-center justify-center">
        <v-col class="text-h2 text-center font-weight-bold text-decoration-underline">Admin Portal</v-col>
        <v-col cols="auto">
        <v-btn class="text-center font-weight-normal text-decoration-underline"
        @click="goToAdminLogin()">
        Log Out
        </v-btn>
        </v-col>
      </v-row>

      <ul></ul>
      <ul></ul>

      <v-row class="d-flex align-center justify-center">
        <v-col class="text-h3 text-left font-weight-normal text-decoration-underline">
            Client List:
        </v-col>
        <v-col class="text-right">
          <v-btn color="primary"
                  size="large"
                  prepend-icon="mdi-plus"
                v-on:click="addRow()"
          >
                <template prepend-icon></template>
                  Register & Add Site
               
        </v-btn>
        </v-col>  
      </v-row>
      <v-table>
        <thead style="background-color: #E1E3E5;">
          <tr>
            <th class="w-40 text-center font-weight-bold" scope="col">Name</th>
            <th class="w-40 text-center font-weight-bold" scope="col">URL</th>
            <th class="w-40 text-center font-weight-bold" scope="col">CallbackUrl</th>
            <th class="w-40 text-center font-weight-bold" scope="col">SuccessUrl</th>
            <th class="w-40 text-center font-weight-bold" scope="col">ErrorUrl</th>
            <th class="w-40 text-center font-weight-bold" scope="col">SiteID</th>
          </tr>
        </thead>
        <tbody style="background-color: #E1E3E5;">
          <tr v-for="row in rows">
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white"
                />{{ row.Name }}
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white"
                />{{ row.URL }}
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white"
                />{{ row.CallbackUrl }}
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white"
                />{{ row.SuccessUrl }}
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white"
                />{{ row.ErrorUrl }}
            </td>
            <td>
              <input
                type="text"
                class="h-8 shadow appearance-white border rounded w-full text-black font-weight-medium text-center leading-tight focus:outline"
                style="background: white"
                />{{ row.SiteID }}
            </td>
          </tr>
        </tbody>
    </v-table>
      
      <div class="py-14" />
    </v-responsive>
  </v-container>
</template>

<script lang="ts" setup>
  import router from '@/router';

  function goToAdminLogin() {
  router.push({ path: '/' });
}
</script>

<script lang="ts">

  export default{
    data(){
      return{
          "Name":"",
          "URL":"",
          "CallbackUrl":"",
          "SuccessUrl":"",
          "ErrorUrl":"",
          "SiteID":"",
          rows:[] as any[]
    }
  },
    methods:{
      addRow(){
        var newRow = {
          "Name" : this['Name'],
          "URL" : this['URL'],
          "CallbackUrl" : this['CallbackUrl'],
          "SuccessUrl" : this['SuccessUrl'],
          "ErrorUrl" : this['ErrorUrl'],
          "SiteID" : this['SiteID'],
        };
        this.rows.push(newRow)

        this['Name'] = "";
        this['URL'] = "";
        this['CallbackUrl'] = "";
        this['SuccessUrl'] = "";
        this['ErrorUrl'] = "";
        this['SiteID'] = "";

      },
      removeRow(){

      }
    }
  }
  
</script>
