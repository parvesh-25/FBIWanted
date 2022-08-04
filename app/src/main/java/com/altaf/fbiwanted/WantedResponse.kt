package com.altaf.fbiwanted

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WantedResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
) : Parcelable

@Parcelize
data class FilesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class ImagesItem(

	@field:SerializedName("original")
	val original: String? = null,

	@field:SerializedName("large")
	val large: String? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null
) : Parcelable

@Parcelize
data class ItemsItem(

	@field:SerializedName("aliases")
	val aliases: List<String?>? = null,

	@field:SerializedName("reward_max")
	val rewardMax: Int? = null,

	@field:SerializedName("scars_and_marks")
	val scarsAndMarks: String? = null,

	@field:SerializedName("reward_min")
	val rewardMin: Int? = null,

//	@field:SerializedName("age_range")
//	val ageRange: Any? = null,

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("race_raw")
	val raceRaw: String? = null,

	@field:SerializedName("height_max")
	val heightMax: Int? = null,

	@field:SerializedName("publication")
	val publication: String? = null,

	@field:SerializedName("modified")
	val modified: String? = null,

//	@field:SerializedName("details")
//	val details: Any? = null,

	@field:SerializedName("hair_raw")
	val hairRaw: String? = null,

//	@field:SerializedName("age_max")
//	val ageMax: Any? = null,

//	@field:SerializedName("possible_states")
//	val possibleStates: Any? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("weight_min")
	val weightMin: Int? = null,

	@field:SerializedName("person_classification")
	val personClassification: String? = null,

//	@field:SerializedName("age_min")
//	val ageMin: Any? = null,

	@field:SerializedName("weight")
	val weight: String? = null,

//	@field:SerializedName("suspects")
//	val suspects: Any? = null,

//	@field:SerializedName("legat_names")
//	val legatNames: Any? = null,

	@field:SerializedName("field_offices")
	val fieldOffices: List<String?>? = null,

	@field:SerializedName("reward_text")
	val rewardText: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("dates_of_birth_used")
	val datesOfBirthUsed: List<String?>? = null,

	@field:SerializedName("weight_max")
	val weightMax: Int? = null,

	@field:SerializedName("files")
	val files: List<FilesItem?>? = null,

	@field:SerializedName("ncic")
	val ncic: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("eyes_raw")
	val eyesRaw: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("occupations")
	val occupations: List<String?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("eyes")
	val eyes: String? = null,

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("hair")
	val hair: String? = null,


	@field:SerializedName("@id")
	val id: String? = null,

	@field:SerializedName("caution")
	val caution: String? = null,

	@field:SerializedName("height_min")
	val heightMin: Int? = null,

	@field:SerializedName("race")
	val race: String? = null,

	@field:SerializedName("languages")
	val languages: List<String?>? = null,

	@field:SerializedName("sex")
	val sex: String? = null,

//	@field:SerializedName("complexion")
//	val complexion: Any? = null,

	@field:SerializedName("subjects")
	val subjects: List<String?>? = null,

//	@field:SerializedName("coordinates")
//	val coordinates: List<Any?>? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("warning_message")
	val warningMessage: String? = null,

	@field:SerializedName("place_of_birth")
	val placeOfBirth: String? = null,

//	@field:SerializedName("additional_information")
//	val additionalInformation: Any? = null,

//	@field:SerializedName("build")
//	val build: Any? = null,

//	@field:SerializedName("locations")
//	val locations: Any? = null,

	@field:SerializedName("remarks")
	val remarks: String? = null
) : Parcelable
