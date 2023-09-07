<template>
  <div style="white-space: nowrap" class="logo-text">
    <div class="d-flex flex-column align-center justify-center">
      <div style="margin: 20px">
        <p class="title-text">상품 유형</p>
      </div>

      <v-container>
        <v-row justify="center">
          <type-button content="예금" @click="navigateToSearchDefault" />
          <type-button content="적금" @click="navigateToSearchSavings" />
          <type-button content="펀드" @click="navigateToSearchFund" />
          <type-button content="대출" @click="navigateToSearchLoan" />
        </v-row>
      </v-container>
    </div>

    <v-card class="mx-auto" flat>
      <v-toolbar color="primary" dark extended flat></v-toolbar>
    </v-card>
    <v-responsive class="mx-auto" max-width="600px" style="margin-top: -75px">
      <v-text-field
        :loading="loading"
        density="compact"
        variant="solo"
        label="상품명을 입력해주세요."
        append-inner-icon="mdi-magnify"
        single-line
        hide-details
        @click:append-inner="onClick"
        rounded="xl"
      ></v-text-field>
    </v-responsive>

    <div class="box-color py-10">
      <v-container>
        <v-row class="flex-child text-subtitle-2">
          <v-col class="mx-auto" width="900">
            <v-sheet class="box-color">
              <!-- FundCard 컴포넌트에 데이터 전달 -->
              <fund-card
                v-for="productDetail in fundData"
                :key="productDetail.id"
                :fundName="productDetail.fundName"
                :fundInfo="productDetail.fundInfo"
                :returnRate1="productDetail.returnRate1"
                :returnRate2="productDetail.returnRate2"
                :fundPrice="productDetail.fundPrice"
                :fundType="productDetail.fundType"
              />
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script setup>
import { ref, onBeforeMount } from "vue";
import { useRouter } from "vue-router";
import { getApi } from "@/api/modules";
import TypeButton from "@/components/button/TypeButton.vue";
import FundCard from "@/components/card/product/FundCard.vue";

const loaded = ref(false);
const loading = ref(false);
const router = useRouter();
const fundData = ref([]);

onBeforeMount(async () => {
  const data = await getApi({
    url: "/product/fund",
  });
  fundData.value = data;
});

const onClick = () => {
  loading.value = true;

  setTimeout(() => {
    loading.value = false;
    loaded.value = true;
  }, 1000);
};

const navigateToSearchDefault = () => {
  router.push({ name: "SearchDefault" });
};

const navigateToSearchSavings = () => {
  router.push({ name: "SearchSavings" });
};

const navigateToSearchFund = () => {
  router.push({ name: "SearchFund" });
};

const navigateToSearchLoan = () => {
  router.push({ name: "SearchLoan" });
};
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 700;
  font-style: normal;
}

.logo-text {
  font-size: 18px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif;
}

.title-text {
  font-size: 30px;
  font-family: "WooridaumB", sans-serif;
}

.box-color {
  background-color: #eeeeee;
}
</style>