package com.blursapp.filtermodule

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import java.net.URL
import com.blursapp.filtermodule.filters.gaussianblur.GaussianBlurFilter

class FilterModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("FilterModule")

    Constants(
      "PI" to Math.PI
    )

    Events("onChange")

    Function("hello") {
      "Hello world! 👋"
    }

    AsyncFunction("setValueAsync") { value: String ->
      sendEvent("onChange", mapOf(
        "value" to value
      ))
    }

    // ✅ YOUR FILTER
    AsyncFunction("applyGaussianBlur") { base64: String, blurStrength: Double ->
      GaussianBlurFilter.apply(base64, blurStrength)
    }

    View(FilterModuleView::class) {
      Prop("url") { view: FilterModuleView, url: URL ->
        view.webView.loadUrl(url.toString())
      }
      Events("onLoad")
    }
  }
}
