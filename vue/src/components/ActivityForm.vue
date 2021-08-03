<template>
   <form v-on:submit.prevent="submitForm" class="activityForm">
 

     <div class="form-group">
        <label for="date">Date:</label>
        <input id="date" type="text" class="form-control" v-model="home.address.addressLine" />
      </div>

      <div class="form-group">
        <label for="mlsNumber">Activity:</label>
        <input id="mlsNumber" type="text" class="form-control" v-model="home.mlsNumber" />
      </div>

     <div class="form-group">
        <label for="city">Distance:</label>
        <input id="city" type="text" class="form-control" v-model="home.address.city" />
      </div>


      <button class="btn btn-submit">Submit</button>
      <button class="btn btn-cancel" type="cancel">Cancel</button>
    </form>


</template>

<script>

export default {
name: "activity-form",
data() {
    return {
        activity: {
            activityId: null,
            userId: null,
            date: "",
            activityType: "",
            distance: ""
        }

    };

}


}



</script>



<style>

</style>