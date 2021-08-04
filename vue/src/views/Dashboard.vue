<template>
  <div class="dashboard">
    <activity-form class="form"/>
    <my-events class="events"/>
    <my-activities class="activities"/>
    <my-badges class="badges"/>
  </div>
</template>

<script>
import ActivityForm from '../components/ActivityForm.vue'
import MyActivities from '../components/MyActivities.vue'
import MyBadges from '../components/MyBadges.vue'
import MyEvents from '../components/MyEvents.vue'

export default {
  components: { MyEvents, ActivityForm, MyActivities, MyBadges },

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
.badges {
  grid-area: badges;
}
.dashboard {
display: grid;
grid-template-columns: 1fr 1fr 1fr;
grid-template-areas: 
"form form form"
"events activities badges";

}

</style>