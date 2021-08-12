<template>
 <div>
   <div class="footer">
      <div class="copyright">
      © 2001 Team Foxtrot <br>
      About Us
      </div>
   
  
      <div class="social">
        <i class="fab fa-facebook-square fa-2x"></i>
        <i class="fab fa-instagram-square fa-2x"></i>
        <i class="fab fa-twitter-square fa-2x"></i>
        <i class="fab fa-pinterest-square fa-2x"></i>
        <i class="fab fa-linkedin fa-2x"></i>
      </div>  
  </div>
 </div> 
 
</template>

<script>
export default {
name: 'the-footer',
}
</script>

<style scoped>


.footer {
  display: flex;
  justify-content: center;
  height: 100%;
  background-color: #cfe6e0;
  padding: 1% 15%;
  overflow: hidden;
  font-size: 18px;
}


i {
  margin: 3%;
}
.copyright {
  flex-grow: 3;
}

.social {
  flex-grow: 1;
  display: inline;
}

</style>