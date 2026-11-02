/**
 * 美味食譜 RecipeApp - Documentation Website Interactivity
 */

document.addEventListener('DOMContentLoaded', () => {
  initThemeToggle();
  initSimulatorTabs();
  initServingsCalculator();
  initSimulatorTimer();
  initCodeCopyButtons();
  initMobileNav();
  initScrollSpy();
});

/* ---------------------------------------------------------
 * 1. Dark / Light Theme Toggle
 * --------------------------------------------------------- */
function initThemeToggle() {
  const themeToggle = document.getElementById('themeToggle');
  const themeIcon = themeToggle?.querySelector('.theme-icon');
  const storedTheme = localStorage.getItem('recipe_docs_theme');

  if (storedTheme) {
    document.body.setAttribute('data-theme', storedTheme);
    updateThemeIcon(storedTheme);
  } else if (window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches) {
    document.body.setAttribute('data-theme', 'dark');
    updateThemeIcon('dark');
  }

  themeToggle?.addEventListener('click', () => {
    const currentTheme = document.body.getAttribute('data-theme') || 'light';
    const nextTheme = currentTheme === 'light' ? 'dark' : 'light';
    document.body.setAttribute('data-theme', nextTheme);
    localStorage.setItem('recipe_docs_theme', nextTheme);
    updateThemeIcon(nextTheme);
  });

  function updateThemeIcon(theme) {
    if (themeIcon) {
      themeIcon.textContent = theme === 'dark' ? '☀️' : '🌙';
    }
  }
}

/* ---------------------------------------------------------
 * 2. Interactive UI Simulator Screen Switcher
 * --------------------------------------------------------- */
function initSimulatorTabs() {
  const tabs = document.querySelectorAll('.sim-tab');
  tabs.forEach(tab => {
    tab.addEventListener('click', () => {
      const targetScreen = tab.getAttribute('data-screen');
      switchSimTab(targetScreen);
    });
  });
}

window.switchSimTab = function(screenName) {
  // Update tabs
  document.querySelectorAll('.sim-tab').forEach(tab => {
    if (tab.getAttribute('data-screen') === screenName) {
      tab.classList.add('active');
    } else {
      tab.classList.remove('active');
    }
  });

  // Update screens
  document.querySelectorAll('.sim-screen').forEach(screen => {
    if (screen.id === `screen-${screenName}`) {
      screen.classList.add('active');
    } else {
      screen.classList.remove('active');
    }
  });
};

/* ---------------------------------------------------------
 * 3. Dynamic Servings Calculator (Simulates Compose Logic)
 * --------------------------------------------------------- */
function initServingsCalculator() {
  const servingsNumEl = document.getElementById('simServingsNum');
  const minusBtn = document.getElementById('simMinusBtn');
  const plusBtn = document.getElementById('simPlusBtn');
  const ingAmts = document.querySelectorAll('.ing-amt');

  let currentServings = 4;
  const baseServings = 4;

  function updateAmounts() {
    if (servingsNumEl) servingsNumEl.textContent = currentServings;
    const multiplier = currentServings / baseServings;

    ingAmts.forEach(el => {
      const baseVal = parseFloat(el.getAttribute('data-base'));
      if (!isNaN(baseVal)) {
        const calculated = baseVal * multiplier;
        const unit = el.textContent.replace(/[0-9.]/g, '').trim();
        const formatted = (calculated % 1 === 0) ? calculated : calculated.toFixed(1);
        el.textContent = `${formatted} ${unit}`;
        el.style.transform = 'scale(1.15)';
        setTimeout(() => { el.style.transform = 'scale(1)'; }, 150);
      }
    });
  }

  minusBtn?.addEventListener('click', () => {
    if (currentServings > 1) {
      currentServings--;
      updateAmounts();
    }
  });

  plusBtn?.addEventListener('click', () => {
    if (currentServings < 20) {
      currentServings++;
      updateAmounts();
    }
  });
}

/* ---------------------------------------------------------
 * 4. Interactive Cooking Timer Countdown
 * --------------------------------------------------------- */
function initSimulatorTimer() {
  const digitsEl = document.getElementById('simTimerDigits');
  const playPauseBtn = document.getElementById('simPlayPauseTimer');
  const resetBtn = document.getElementById('simResetTimer');
  const addMinuteBtn = document.getElementById('simAddMinute');

  let remainingSeconds = 45 * 60 - 8; // 44:52
  let isRunning = true;
  let timerInterval = null;

  function formatTime(secs) {
    const m = Math.floor(secs / 60);
    const s = secs % 60;
    return `${String(m).padStart(2, '0')}:${String(s).padStart(2, '0')}`;
  }

  function tick() {
    if (remainingSeconds > 0) {
      remainingSeconds--;
      if (digitsEl) digitsEl.textContent = formatTime(remainingSeconds);
    } else {
      clearInterval(timerInterval);
      isRunning = false;
      if (playPauseBtn) playPauseBtn.textContent = '▶️';
      if (digitsEl) digitsEl.textContent = '00:00';
    }
  }

  // Start initial running
  timerInterval = setInterval(tick, 1000);

  playPauseBtn?.addEventListener('click', () => {
    if (isRunning) {
      clearInterval(timerInterval);
      isRunning = false;
      playPauseBtn.textContent = '▶️';
    } else {
      if (remainingSeconds > 0) {
        timerInterval = setInterval(tick, 1000);
        isRunning = true;
        playPauseBtn.textContent = '⏸️';
      }
    }
  });

  resetBtn?.addEventListener('click', () => {
    clearInterval(timerInterval);
    remainingSeconds = 45 * 60;
    if (digitsEl) digitsEl.textContent = formatTime(remainingSeconds);
    isRunning = false;
    if (playPauseBtn) playPauseBtn.textContent = '▶️';
  });

  addMinuteBtn?.addEventListener('click', () => {
    remainingSeconds += 60;
    if (digitsEl) digitsEl.textContent = formatTime(remainingSeconds);
  });
}

/* ---------------------------------------------------------
 * 5. Code Copy Buttons
 * --------------------------------------------------------- */
function initCodeCopyButtons() {
  window.copyCode = function(btn) {
    const codeBlock = btn.closest('.code-header')?.nextElementSibling?.querySelector('code') ||
                      btn.parentElement?.nextElementSibling;
    const textToCopy = codeBlock ? codeBlock.innerText : '';

    if (navigator.clipboard && textToCopy) {
      navigator.clipboard.writeText(textToCopy).then(() => {
        const originalText = btn.textContent;
        btn.textContent = '已複製 ✓';
        btn.style.background = '#2E7D32';
        setTimeout(() => {
          btn.textContent = originalText;
          btn.style.background = '';
        }, 2000);
      });
    }
  };
}

/* ---------------------------------------------------------
 * 6. Mobile Navigation Drawer
 * --------------------------------------------------------- */
function initMobileNav() {
  const toggleBtn = document.getElementById('mobileNavToggle');
  const nav = document.querySelector('.header-nav');

  toggleBtn?.addEventListener('click', () => {
    nav?.classList.toggle('mobile-open');
  });

  nav?.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', () => {
      nav.classList.remove('mobile-open');
    });
  });
}

/* ---------------------------------------------------------
 * 7. Active Sidebar Scroll Spy
 * --------------------------------------------------------- */
function initScrollSpy() {
  const sections = document.querySelectorAll('.doc-section');
  const navLinks = document.querySelectorAll('.sidebar-links a');

  window.addEventListener('scroll', () => {
    let currentId = '';
    const scrollPos = window.scrollY + 120;

    sections.forEach(section => {
      const top = section.offsetTop;
      const height = section.offsetHeight;
      if (scrollPos >= top && scrollPos < top + height) {
        currentId = section.getAttribute('id');
      }
    });

    if (currentId) {
      navLinks.forEach(link => {
        if (link.getAttribute('href') === `#${currentId}`) {
          link.classList.add('active');
        } else {
          link.classList.remove('active');
        }
      });
    }
  });
}
