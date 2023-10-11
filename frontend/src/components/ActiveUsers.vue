<template>
  <div class="container-sm mt-3">
    <table class="table table-striped">
      <thead>
      <tr>
        <th scope="col" class="clickable text-nowrap" @click="sortById">Id</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByUsername">Username</th>
      </tr>
      </thead>
      <tbody>
      <tr
          v-for="user in users"
          :key="user.id">
        <td>{{user.userId}}</td>
        <td>{{user.username}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>


import axios from "axios";
import {useAuth} from "../stores/auth.js";

const userdata = useAuth();
const config = {
  headers: {
    Authorization: `Bearer ${userdata.token}`
  }
};
const apiBaseUrl = "/api/user";

export default {
  name: 'ActiveUsers',
  data() {
    return {
      config: config,
      token: userdata.token,
      users: [],
    };
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    async fetchUsers() {

      try {
        const response = await axios.get(apiBaseUrl + "/all", config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users: ", e);
      }
    },
    async sortById() {
      const sorting = "userId";
      try {
        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log(`Error fetching Users with desired sorting method: ${sorting}`, e);
      }
    },
    async sortByUsername() {
      const sorting = "username";
      try {
        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByFirst() {
      const sorting = "firstname";
      try {

        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByLast() {
      const sorting = "lastname";
      try {

        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByRole() {
      const sorting = "role";
      try {

        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: "role"}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByLogin() {
      const sorting = "last login";
      try {

        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: "login"}, config);
        this.users = response.data;
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByIncidents() {
      const sorting = "assigned Incidents";
      try {

        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: "incidents"}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByPasswordChanges() {
      const sorting = "password change";
      try {

        const response = await axios.post(apiBaseUrl + "/customSort", {sorting: "pwchanges"}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    testMethod() {
      alert("Geht");
    },
    deleteUser(id) {
      if (confirm("Do you really want to delete User with id: " + id)) {
        alert("Deleted");
      }
    }
  }
}

</script>

<style>
.clickable{
  cursor: pointer;
}

</style>