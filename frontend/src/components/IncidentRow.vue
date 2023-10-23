<template>
  <div class="container p-0">
    <div class="row mt-4 mb-4">
      <div class="col">
        <h4>Actual open incidents: {{incidents.length}}</h4>
      </div>
      <div class="col text-end">
        <div class="btn-group" role="group">
          <button type="button" class="btn btn-outline-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Sort by
          </button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" @click="sort">Category</a></li>
            <li><a class="dropdown-item" @click="sort">Severity</a></li>
            <li><a class="dropdown-item" @click="sort">User</a></li>
            <li><a class="dropdown-item" @click="sort">Report Date</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <div class="card mb-3 border border-1 border-dark-subtle"
       v-for="incident in incidents"
       :key="incidentId"
       @click="goToDetails(incident.incidentId)">
    <div class="card-header" :class="{
      'bg-danger':incident.severity === 1,
      'bg-danger-subtle': incident.severity === 2,
      'bg-warning': incident.severity === 3,
      'bg-warning-subtle': incident.severity === 4
      }">
      <div class="row">
        <div class="col">
          <b class="mb-0 text-uppercase">{{ incident.categoryName }}</b>
        </div>
        <div class="col text-end">
              <span v-bind="$attrs">
          <p v-if="incident.solved"> Status: <b class="badge bg-white text-dark-emphasis">solved</b></p>
          <p v-else> Status: <b class="badge bg-white text-dark-emphasis">open</b></p>
        </span>
        </div>
      </div>
    </div>
    <div class="card-body">
      <h5 class="card-title">{{incident.titel}}</h5>
      <p class="card-text">{{incident.description}}</p>
    </div>
    <div class="card-footer text-body-secondary">
      <div class="row">
        <div class="col">created at: {{incident.reportdate}}</div>
        <div class="col text-center">{{ incident.assignedUser }}</div>
        <div class="col text-end">
          <div class="btn-group m-0" role="group">
            <button type="button" class="btn btn-outline-success" @click.stop="solved(incident.incidentId)">Mark as solved</button>
            <button type="button" class="btn btn-outline-danger" @click.stop="deleteIncident(incident.incidentId)">Delete</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from "../router/routes.js";
import {useAuth} from "../stores/auth.js";
import {duration} from "../stores/durationStore.js";

const userdata = useAuth();
const config = {
  headers: {
    Authorization: `Bearer ${this.token}`
  }
}

export default {
  name: 'IncidentTable',
  data(){
    return {
      token: userdata.token,
      incidents: [],
      duration
    };
  },
  created() {
    this.fetchIncidents();
  },
  computed() {
    this.isAdmin();
  },
  methods: {
    isAdmin() {
      return localStorage.getItem('isAdmin') === 'true';
    },
    async fetchIncidents() {
      const config = {
        headers: {
          Authorization: `Bearer ${this.token}`
        },
      };
      try {
        const response = await axios.get('api/incident/all', config);
        this.incidents = response.data;
        console.log(response.data);
        } catch (error) {
        console.error('Error occurred fetching incidents:', error)
      }
    },
    goToDetails(id) {

      router.push({
        name: 'incident-details',
        params: {
          id: id
        }
      });
    },
    async deleteIncident(incidentId) {

      try {
        await axios.delete(`/api/incident/${incidentId}`, this.config);
        await this.fetchIncidents();
        await alert("deleted");
      } catch (error) {
        console.error('Error occurred deleting incidents:', error)
      }
    },
    solved(incidentId) {
      console.log(incidentId)
      try{
        axios.patch(`/api/incident/${incidentId}`, this.config)
      }
      catch (error) {
        console.log("Error patching data: ", error);
      }

    },
    sort() {
      alert("Feature is planned");
    }



  }

};

</script>

<style>
.card:hover {
  -webkit-box-shadow: 5px 5px 12px -3px #878787;
  box-shadow: 5px 5px 12px -3px #878787;
}
.card {
  transition: box-shadow .5s;
}

</style>
