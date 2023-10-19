<template>

  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4" :UserId="UserId">
    <div class="row">
        <form class="card border-0">
          <div class="input-group mb-3">
            <input type="file" class="form-control" id="profile-image">
            <label class="input-group-text" for="profile-image">Profile Image</label>
          </div>
          <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Username</span>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="addon-wrapping" v-model="formdata.username">
          </div>
          <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Firstname</span>
            <input type="text" class="form-control" aria-label="Firstname" aria-describedby="addon-wrapping"
                   v-model="formdata.firstname">
            <span class="input-group-text" id="addon-wrapping">Lastname</span>
            <input type="text" class="form-control" aria-label="Lastname" aria-describedby="addon-wrapping" v-model="formdata.lastname">

            <span class="input-group-text" id="addon-wrapping">Password</span>
            <input type="password" class="form-control" aria-label="password" aria-describedby="addon-wrapping" v-model="formdata.password">
          </div>
          <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Confirm Password</span>
            <input type="password" class="form-control" aria-label="confirmPassword" aria-describedby="addon-wrapping" v-model="confirmPassword">
          </div>
          <div class="input-group flex-nowrap mb-3">
            <select class="form-select me-3" id="userRole" v-model="formdata.userRole" @change="setUserRole($event)">
              <option value="2" selected>User</option>
              <option value="1">Admin</option>
            </select>
          </div>
          <button class="btn btn-outline-success" type="submit">Sign in</button>
        </form>

    </div>
  </div>


</template>

<script>

import {useAuth} from "../stores/auth.js";
import axios from "axios";

const userdata = useAuth();
const userId = userdata.userId;
const token = userdata.token;

const config = {
  headers: {
    Authorization: `Bearer ${token}`
  },
};

export default {
  name: "UserForm",
  data() {
    return {
      formdata: {
        username: '',
        firstname: '',
        lastname: '',
        password: '',
        userRole: ''
      },
      confirmPassword: ''
    }
  },
  methods: {
    setUserRole(event) {
      this.userRole = event.target.value;
    },
    async submitForm(){
      axios
          .post("/api/user/create", this.formdata, config)
          .then((response) => {
            const status = response.status;
            if(status === 409) {
              alert("Username already exists, please choose another one!");
              this.formdata.username = '';
            } else if (status === 201) {
              alert("User created successfully");
              Object.keys(this.formdata).forEach((key) => {
                this.formdata[key] = '';
              });
              this.confirmPassword = '';
            }
          })
          .catch(error => {
            console.log("An error occurred creating a new user", error);
          });
    }

  }
}


</script>
<style scoped>
.card:hover {
  box-shadow: none;
}

#delete:hover {
  background-color: #dc3545;
  color: white;
}

#change:hover {
  background-color: #ffda6a;
  color: black;
}

#edit:hover {
  background-color: #6610f2;
  color: white;
}
</style>