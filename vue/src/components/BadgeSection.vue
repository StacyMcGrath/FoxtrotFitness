<template>
  <div class="badgesection">
      <h4 id="badgeheader">My Badges</h4>
        <img class="badgeimage" id="b1" src="../assets/medal.png">
        <img class="badgeimage" id="b2" src="../assets/shoe.png">
        <img class="badgeimage" id="b3" src="../assets/bike.png">
        <img class="badgeimage" id="b4" src="../assets/Plus.png">
  </div>
</template>

<script>
export default {
name: 'badge-section'

}
</script>

<style>
.badgesection {
    display: grid;
    width: 80%;
    height: 70%;
    padding: 3%;
    padding-bottom: 25%;
    border-radius: 8px;
    box-shadow: 0 1px 5px 0 rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.19);
    background-color: #edf0db;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
    grid-template-areas: "header header header header header header"
                        "b2 b1 b3 b4 . ."
                        ". . . . . ."
    
}

#badgeheader {
    grid-area: header;
    font-family: 'Montserrat', sans-serif;
    color: #505170;
    font-style: normal;
    font-weight: bold;
    font-size: 24px;
    line-height: 36px;
}
#b1 {
    grid-area: b1;
}
#b2 {
    grid-area: b2;
}
#b3 {
    grid-area: b3;
}

.badgeimage {
 width: 60px;
 height: auto;
 margin: 0%;
}
</style>