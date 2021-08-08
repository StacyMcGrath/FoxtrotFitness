<template>
<div>
  <event-detail />
  <group-progress />
  <individual-progress />
</div>
</template>

<script>
import EventDetail from '../components/EventDetail.vue'
import GroupProgress from '../components/GroupProgress.vue'
import IndividualProgress from '../components/IndividualProgress.vue'
export default {
  components: { EventDetail, GroupProgress, IndividualProgress },



}
</script>

<style>

</style>