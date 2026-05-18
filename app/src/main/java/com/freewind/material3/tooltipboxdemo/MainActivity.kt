    @file:OptIn(ExperimentalMaterial3Api::class)

    package com.freewind.material3.tooltipboxdemo

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.foundation.text.input.rememberTextFieldState
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.*
    import androidx.compose.material3.*
    import androidx.compose.material3.carousel.rememberCarouselState
    import androidx.compose.material3.pulltorefresh.PullToRefreshBox
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.state.ToggleableState
    import androidx.compose.ui.unit.dp

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MaterialTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        DemoScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun DemoScreen() {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("TooltipBox") },
                    )
                },
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                          val state = rememberTooltipState(initialIsVisible = true)
                          TooltipBox(
                            tooltip = {
                                PlainTooltip {
                                    Text("TooltipBox")
                                }
                            },
                            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),

                              state = state,
                          ) {
                              IconButton(onClick = {}) {
                                  Icon(Icons.Default.Info, contentDescription = null)
                              }
                          }

                }
            }

    }
