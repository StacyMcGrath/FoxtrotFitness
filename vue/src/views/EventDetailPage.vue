<template>
<div>
  <event-detail />
  <!-- <group-progress v-show="$store.state.token != ''"/> -->
  <!-- <individual-progress /> -->
  <!-- <event-leaderboard /> -->
</div>
</template>

<script>
import EventDetail from '../components/EventDetail.vue'
// import EventLeaderboard from '../components/EventLeaderboard.vue'
// import GroupProgress from '../components/GroupProgress.vue'
// import IndividualProgress from '../components/IndividualProgress.vue'
export default {
  components: { EventDetail
   },

}
</script>

<style>

</style>