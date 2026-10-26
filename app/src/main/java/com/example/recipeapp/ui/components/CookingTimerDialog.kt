package com.example.recipeapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.recipeapp.viewmodel.TimerUiState

@Composable
fun CookingTimerDialog(
    timerState: TimerUiState,
    onTogglePlayPause: () -> Unit,
    onAddMinute: () -> Unit,
    onReset: () -> Unit,
    onClose: () -> Unit
) {
    if (!timerState.isVisible) return

    Dialog(onDismissRequest = onClose) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 8.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header row with close button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Timer,
                            contentDescription = "Timer",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "烹飪計時器",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    IconButton(onClick = onClose) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Title of step
                Text(
                    text = timerState.title.ifEmpty { "烹調計時中" },
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Circular Progress with Digital Clock
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(190.dp)
                ) {
                    // Background track
                    CircularProgressIndicator(
                        progress = { 1f },
                        modifier = Modifier.size(180.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        strokeWidth = 10.dp
                    )
                    // Active track
                    val isDone = timerState.remainingSeconds == 0 && timerState.totalSeconds > 0
                    CircularProgressIndicator(
                        progress = { timerState.progress },
                        modifier = Modifier.size(180.dp),
                        color = if (isDone) Color(0xFF43A047) else MaterialTheme.colorScheme.primary,
                        strokeWidth = 10.dp
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (isDone) {
                            Text(
                                text = "⏰ 時間到！",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2E7D32)
                            )
                            Text(
                                text = "請檢查火候或進行下一步",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        } else {
                            Text(
                                text = timerState.formattedTime,
                                fontSize = 42.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (timerState.isRunning) "計時中..." else "已暫停",
                                style = MaterialTheme.typography.labelSmall,
                                color = if (timerState.isRunning) MaterialTheme.colorScheme.primary else Color.Gray
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Controls row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Reset button
                    FilledTonalButton(
                        onClick = onReset,
                        shape = CircleShape,
                        modifier = Modifier.size(50.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Reset",
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    // Main Start/Pause button
                    Button(
                        onClick = onTogglePlayPause,
                        shape = CircleShape,
                        modifier = Modifier.size(64.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                    ) {
                        Icon(
                            imageVector = if (timerState.isRunning) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (timerState.isRunning) "Pause" else "Start",
                            modifier = Modifier.size(32.dp),
                            tint = Color.White
                        )
                    }

                    // +1 Minute button
                    FilledTonalButton(
                        onClick = onAddMinute,
                        shape = CircleShape,
                        modifier = Modifier.size(50.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add 1 min",
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = "1m",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
