<template>
<div>
  <h1>{{UserProfile.firstName}}'s Dashboard </h1>
  <activity-form class="form"/>
  <div class="dashboard">
    <my-events class="events"/>
    <my-activities class="activities"/>
    <my-goals class="goals"/>
  </div>
</div>  
</template>

<script>
import ActivityForm from '../components/ActivityForm.vue'
import MyActivities from '../components/MyActivities.vue'
import MyGoals from '../components/MyGoals.vue'
import MyEvents from '../components/MyEvents.vue'
import eventService from '../services/EventService.js'

export default {
  components: { MyEvents, ActivityForm, MyActivities, MyGoals },
  data() {
    return {
    UserProfile: {}
  };
  },

  created() {
    eventService.getUserProfileForLoggedInUser().then(response => {
    this.UserProfile = response.data;
      })
    },
}
</script>

<style scoped>

.form {
  grid-area: form;
  
}
.events {
  grid-area: events;
}
.activities {
  grid-area: activities;
}
.goals {
  grid-area: goals;
}
.dashboard {
margin: 0 3%;
display: grid;
justify-items: center;
grid-template-columns: 1fr 1.25fr 1fr;
grid-template-areas: 
"goals activities events";

}

h1 {
  margin: 1% 0 0 5%;

}

</style>