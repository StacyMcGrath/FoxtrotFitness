<template>
<div>
  <h1>{{UserProfile.firstName}}'s Dashboard </h1>
  <div class="topsection">
    <activity-form class="form" id="activityform"/>
    <badge-section id="badgesection"/>
  </div>
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
import BadgeSection from '../components/BadgeSection.vue'

export default {
  components: { MyEvents, ActivityForm, MyActivities, MyGoals, BadgeSection },
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


.topsection {
margin: 0 5% 3%;
display: grid;
grid-template-columns: 1fr 1fr;
grid-template-areas: 
"activityform badgesection";
}
#activityform {
  grid-area: activityform;
}

#badgesection {
  grid-area: badgesection;
}

h1 {
  margin: 1% 0 0 5%;

}

</style>