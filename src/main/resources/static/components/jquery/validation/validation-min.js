
(function (B) {
	var s = B.Validation;
	var b = function (L, K) {
		this.initialize.apply(this, arguments);
	};
	b.version = "1.2.9";
	function F(N, K, P) {
		if (typeof N === "object" && typeof N.length === "number") {
			for (var M = 0, O = N.length; M < O; ++M) {
				if (K.call(P, N[M], M, N) === false) {
					break;
				}
			}
		} else {
			for (var L in N) {
				if (K.call(P, N[L], L, N) === false) {
					break;
				}
			}
		}
		return N;
	}
	function p(M, K, N) {
		var L = true;
		F(M, function (P, O) {
			if (!K.call(N, P, O, M)) {
				L = false;
				return false;
			}
		});
		return L;
	}
	function v(M, K, N) {
		var L = false;
		F(M, function (P, O) {
			if (K.call(N, P, O, M)) {
				L = true;
				return false;
			}
		});
		return L;
	}
	function i() {
		var M = arguments[0] || {};
		for (var L = 1, O = arguments.length; L < O; ++L) {
			var N = arguments[L];
			for (var K in N) {
				if (N[K] !== undefined) {
					M[K] = N[K];
				}
			}
		}
		return M;
	}
	function n(K) {
		return !K || K.length == 0 || /^\s+$/.test(K);
	}
	function r(K) {
		return K !== null && typeof K === "object" && K.splice && K.join && K.sort;
	}
	function f(K) {
		return r(K) ? K : [K];
	}
	function a(K) {
		return (K || "").replace(/^\s+|\s+$/g, "");
	}
	function e(K, L) {
		return function () {
			return K.apply(L || this, arguments);
		};
	}
	var w = x;
	function x(K) {
		return (typeof K === "string") ? document.getElementById(K) : K;
	}
	function y(K) {
		return K.tagName.toLowerCase();
	}
	function A(N) {
		var K = y(N);
		if (K == "select") {
			var L = [];
			F(N.options, function (O) {
				O.selected && L.push(O.value);
			});
			return N.multiple ? L : L[0];
		} else {
			if (K == "input") {
				var M = N.type.toLowerCase();
				if ((M == "checkbox" || M == "radio") && !N.checked) {
					return false;
				}
			}
		}
		return N.value;
	}
	var j = {}, E = "validation" + new Date().getTime(), g = 0, D = {};
	function J(N, K, L) {
		N = (N == B) ? D : N;
		var M = N[E];
		if (!M) {
			M = N[E] = ++g;
		}
		j[M] = j[M] || {};
		if (L !== undefined) {
			j[M][K] = L;
		}
		return j[M][K];
	}
	function u(N, K) {
		N = (N == B) ? D : N;
		var M = N[E];
		if (!j[M]) {
			return;
		}
		delete j[M][K];
		K = "";
		for (K in j) {
			break;
		}
		if (!K) {
			try {
				delete N[E];
			}
			catch (L) {
				N.removeAttribute && N.removeAttribute(E);
			}
			delete j[M];
		}
	}
	function h(M, L, K) {
		if (M.addEventListener) {
			M.addEventListener(L, K, false);
		} else {
			if (M.attachEvent) {
				M.attachEvent("on" + L, K);
			}
		}
	}
	function c(M, L, K) {
		if (M.removeEventListener) {
			M.removeEventListener(L, K, false);
		} else {
			if (M.detachEvent) {
				M.detachEvent("on" + L, K);
			}
		}
	}
	function H(K) {
		K = K || B.event;
		K.returnValue = false;
		K.preventDefault && K.preventDefault();
	}
	function t(K) {
		return (K.className || "").split(/\s+/);
	}
	function C(M, L) {
		var K = (" " + M.className + " ").replace(/[\n\t]/g, " ");
		return (K.indexOf(" " + L + " ") > -1);
	}
	function q(L, K) {
		if (L.className) {
			if (!C(L, K)) {
				L.className = L.className + " " + K;
			}
		} else {
			L.className = K;
		}
	}
	function m(M, L) {
		var K = (" " + M.className + " ").replace(/[\n\t]/g, " ");
		M.className = a(K.replace(" " + L + " ", " "));
	}
	function I(L) {
		var K = [];
		F(L.getElementsByTagName("*"), function (N) {
			var M = y(N);
			if (M == "input" || M == "select" || M == "textarea") {
				K.push(N);
			}
		});
		return K;
	}
	function z(M, L) {
		if (b.show) {
			return b.show(M, L);
		}
		if (b.show === false) {
			M.style.display = "";
			L && L();
			return;
		}
		if (typeof jQuery !== "undefined") {
			jQuery(M).fadeIn("slow", L);
		} else {
			if (typeof Prototype !== "undefined" && typeof Effect !== "undefined") {
				w(M).appear({afterFinish:L});
			} else {
				if (typeof MooTools !== "undefined" && typeof Fx !== "undefined") {
					M = w(M);
					if (M.getStyle("display") == "none") {
						M.setStyles({opacity:0, display:""});
						var K = new Fx.Tween(M, {onComplete:L});
						K.start("opacity", 1);
					}
				} else {
					M.style.display = "";
					L && L();
				}
			}
		}
	}
	function G(M, L) {
		if (b.hide) {
			return b.hide(M, L);
		}
		if (b.hide === false) {
			M.style.display = "none";
			L && L();
			return;
		}
		if (typeof jQuery !== "undefined") {
			jQuery(M).fadeOut("slow", L);
		} else {
			if (typeof Prototype !== "undefined" && typeof Effect !== "undefined") {
				w(M).fade({afterFinish:L});
			} else {
				if (typeof MooTools !== "undefined" && typeof Fx !== "undefined") {
					M = w(M);
					var K = new Fx.Tween(M);
					K.start("opacity", 0).chain(function () {
						M.setStyle("display", "none");
						L && L();
					});
				} else {
					M.style.display = "none";
					L && L();
				}
			}
		}
	}
	function k(L) {
		if (b.activate) {
			return b.activate(L);
		}
		try {
			L.focus();
			L.select && L.select();
		}
		catch (K) {
		}
	}
	function o(N, M) {
		if (!M) {
			return null;
		}
		if (M[N]) {
			return M[N];
		}
		if (N.id && M[N.id]) {
			return M[N.id];
		}
		var L = t(N);
		var K = null;
		F(L, function (O) {
			var P = M["." + O];
			if (P) {
				K = P;
				return false;
			}
		});
		return K;
	}
	var l = function () {
		this.initialize.apply(this, arguments);
	};
	i(l.prototype, {initialize:function (L, K) {
		this.test = (typeof L === "function") ? {test:L} : L;
		this.options = K || {};
	}, validate:function (K, L) {
		return this.options.force ? this._validate(K, L) : (n(K) || this._validate(K, L));
	}, _validate:function (K, L) {
		return (this.options.depends ? p(this.options.depends, function (M) {
			return M.validate(K, L);
		}) : true) && (this.test === true || (this.test.validate || this.test.test).call(this.test, K, L));
	}});
	var d = {};
	d.alert = {fail:function (L, K) {
		K && B.alert(K);
	}};
	d["default"] = {prompt:function (L, K) {
		this._showAdvice(L, "prompt", K);
	}, pass:function (L, K) {
		this._showAdvice(L, "passed", K);
	}, fail:function (L, K) {
		this._showAdvice(L, "failed", K);
	}, reset:function (L) {
		var K = ["prompt", "passed", "failed"];
		F(K, function (N) {
			m(L, "validation-" + N);
			var M = this._getAdvice(L, N);
			if (!M) {
				return;
			}
			if (J(M, "validation")) {
				M.parentNode && M.parentNode.removeChild(M);
			} else {
				m(M, "validation-advice-" + N);
				M.style.display = "none";
			}
		}, this);
		u(L, "validation_advice_default");
	}, _showAdvice:function (P, N, O) {
		var L = ["prompt", "passed", "failed"];
		F(L, function (Q) {
			(Q == N ? q : m)(P, "validation-" + Q);
		});
		var K = this._getAdvice(P, N);
		if (!K && O) {
			K = this._createAdvice(P);
			this._setAdvice(P, K);
		}
		if (N == "prompt" && (!K || (J(K, "validation") && !O))) {
			return;
		}
		F(L, function (R) {
			if (R == N) {
				return;
			}
			var Q = this._getAdvice(P, R);
			if (!Q) {
				return;
			}
			if (K) {
				m(Q, "validation-advice-" + R);
				Q.style.display = "none";
			} else {
				G(Q, function () {
					m(Q, "validation-advice-" + R);
				});
			}
		}, this);
		if (!K) {
			return;
		}
		if (O && !J(K, "validation_message")) {
			K.innerHTML = "";
			var M = P.ownerDocument.createElement("span");
			M.innerHTML = O;
			K.appendChild(M);
		}
		if (O || J(K, "validation_message")) {
			q(K, "validation-advice-" + N);
			z(K);
		}
	}, _getAdvice:function (N, M) {
		var L = J(N, "validation_advice_default") || J(N, "validation_advice_default", {});
		var K = L[M];
		if (K) {
			return K;
		}
		K = N.id ? (x("validation-advice_" + M + "-" + N.id) || x("validation-advice-" + N.id)) : null;
		K = K || x("validation-advice-" + M) || x("validation-advice");
		if (K) {
			L[M] = K;
			a(K.innerHTML) && J(K, "validation_message", true);
		}
		return K;
	}, _setAdvice:function (L, K) {
		J(L, "validation_advice_default", {prompt:K, passed:K, failed:K});
	}, _createAdvice:function (Q) {
		var P = "validation-advice-" + (Q.id || new Date().getTime());
		var K = "<div id=\"" + P + "\" class=\"validation-advice\" style=\"display: none;\"></div>";
		var O = Q.ownerDocument.createElement("div");
		
		O.innerHTML = K;
		K = O.childNodes[0];
		J(K, "validation", true);
		var N = Q.parentNode;
		var M = Q.type.toLowerCase();
		if ((M == "checkbox" || M == "radio") && N) {
			N.appendChild(K);
		} else {
			var L = Q.nextSibling;
			L ? N.insertBefore(K, L) : N.appendChild(K);
		}
		if(typeof($(K).prev().attr("validate")) != "undefined" || typeof($(K).prev().attr("validate"))  == "string"){
			if($(K).parent()[0].tagName.toLowerCase() == "td"){
				$(K).css("top", $(K).prev()[0].offsetTop);
			}else{
				$(K).css("top", $(K).prev()[0].offsetTop - 30);
			}
			$(K).css("left", $(K).prev()[0].offsetLeft - 4);
		}
		return K;
	}};
	i(b, {add:function (L, M, K) {
		if (arguments.length == 1) {
			F(L, function (O, N) {
				O = f(O);
				this.add.call(this, N, O[0], O[1]);
			}, this);
			return this;
		}
		K = i({}, K);
		validators = [];
		K.depends && F(f(K.depends), function (O) {
			var N = this.get(O);
			N && validators.push(N);
		}, this);
		K.depends = validators;
		this._validators[L] = new l(M, K);
		return this;
	}, get:function (K) {
		if (typeof K === "string") {
			return this._validators[K];
		}
		if (y(K) == "form") {
			return J(K, "validation");
		}
		return null;
	}, validate:function (L, K) {
		return this._dispatchCall(L, K, "validate");
	}, validateElement:function (P, M) {
		P = x(P);
		if (M === false) {
			M = {advice:false};
		}
		M = i({}, b.defaultOptions, M);
		var O = this._validateElement(P, M);
		if (O == -3) {
			return true;
		}
		if (M.advice !== false) {
			var L = this._getAdvice(M);
			if (!L) {
				throw new Error("can not find the validation advice:" + M.advice);
			}
			J(P, "validation_advice", L);
			if (O == -1) {
				if (L.pass) {
					var N = this._getMessage(P, "passed", M);
					L.pass(P, N, M);
				}
			} else {
				if (L.fail) {
					var N = this._getMessage(P, "failed", M, O == -2 ? false : O);
					L.fail(P, N, M);
				}
			}
		}
		var K = M.onElementValidate || M.onValidate;
		if (K && K.call(P, O == -1, (O == -2) ? 0 : O) === false) {
			O = -1;
		}
		return O == -1;
	}, validateForm:function (N, K) {
		N = x(N);
		if (K === false) {
			K = {advice:false, focusOnError:false};
		}
		K = i({}, b.defaultOptions, K);
		var L = I(N);
		var M = true;
		var O = [];
		if (K.stopOnFirst) {
			M = p(L, function (Q) {
				var P = this._validateFormElement(Q, K);
				if (!P) {
					O.push(Q);
				}
				return P;
			}, this);
		} else {
			F(L, function (P) {
				if (!this._validateFormElement(P, K)) {
					O.push(P);
					M = false;
				}
			}, this);
		}
		if (K.onFormValidate && K.onFormValidate.call(N, M, K.stopOnFirst ? O[0] : O) === false) {
			M = false;
		}
		!M && K.focusOnError && k(O[0]);
		return M;
	}, reset:function (K) {
		return this._dispatchCall(K, null, "reset");
	}, resetForm:function (K) {
		F(I(x(K)), this.resetElement, this);
		return this;
	}, resetElement:function (L) {
		L = x(L);
		var K = J(L, "validation_advice");
		K && K.reset && K.reset(L);
		u(L, "validation_advice");
		return this;
	}, prompt:function (N, L) {
		N = x(N);
		if (this._getValidators(N, L).length == 0) {
			return;
		}
		var K = this._getAdvice(L);
		var M = this._getMessage(N, "prompt", L);
		K && K.prompt && K.prompt(N, M, L);
	}, _dispatchCall:function (N, K, M) {
		N = x(N);
		var L = y(N) == "form" ? "Form" : "Element";
		return this[M + L](N, K);
	}, _validateElement:function (P, M) {
		var K = this._regularValidators(this._getValidators(P, M));
		if (K.length == 0) {
			return -3;
		}
		var O = A(P);
		var L = -1;
		var N = p(K, function (Q, S) {
			var R = (typeof Q[0] === "string") ? this.get(Q[0]) : new l(Q[0], Q[1]);
			if (!R) {
				throw new Error("can't find installed validator: " + Q[0]);
			}
			if (!R.validate(O, Q[1])) {
				L = S;
				return false;
			}
			return true;
		}, this);
		if (!N && K.length == 1) {
			return -2;
		}
		return L;
	}, _validateFormElement:function (O, L) {
		var N = L.validators;
		var K = L.messages;
		L.validators = o(O, N);
		L.messages = o(O, K);
		var M = b.validateElement(O, L);
		L.validators = N;
		L.messages = K;
		return M;
	}, _getValidators:function (L, K) {
		return K.validators || K.validator || this._getValidatorsFromElm(L);
	}, _regularValidators:function (K) {
		K = f(K);
		var L = [];
		F(K, function (M) {
			var N = typeof M;
			if (N === "string" || N === "function") {
				L.push([M]);
			} else {
				if (r(M)) {
					L.push(M);
				} else {
					if (N === "object") {
						var O = M.validate || M.test;
						if (O && typeof O === "function") {
							L.push([M]);
						} else {
							F(M, function (P, Q) {
								this.get(Q) && L.push([Q, P]);
							}, this);
						}
					}
				}
			}
		}, this);
		return L;
	}, _getValidatorsFromElm:function (L) {
		var K = [];
		F(t(L), function (N) {
			var M = this._getValidatorFromClass(N);
			M && K.push(M);
		}, this);
		return K;
	}, _getValidatorFromClass:function (M) {
		if (M != "required" && M.indexOf("validate-") != 0) {
			return null;
		}
		M = M.replace(/^validate-/, "");
		if (this.get(M)) {
			return M;
		}
		var L = [];
		var O = (M + "-").match(/(-\[\S+?\](?=-))|[^-]+/g);
		for (var N = 0, P = O.length; N < P - 1; ++N) {
			var K = O.pop().replace(/^-\[(\S+)\]$/, "$1");
			L.unshift(K);
			M = O.join("-");
			if (this.get(M)) {
				return [M, L];
			}
		}
		return null;
	}, _getMessage:function (P, N, L, K) {
		var O = L.messages || L.message;
		if (O) {
			if (typeof O === "string" || r(O)) {
				O = {failed:O};
			}
			if (N == "failed") {
				var M = f(O.failed);
				return M[K || 0] || M[0];
			} else {
				return O[N];
			}
		} else {
			O = P.getAttribute((L.messageNames)[N]);
			if (!O && N == "failed" && L.useTitle) {
				O = P.title;
			}
			if (O && N == "failed" && K !== false) {
				var M = O.split(L.messageSeparator);
				return M[K] || M[0];
			}
			return O;
		}
	}, _getAdvice:function (K) {
		var L = typeof K.advice;
		if (L === "string") {
			return d[K.advice];
		} else {
			if (L === "function") {
				return {fail:K.advice};
			} else {
				if (L === "object") {
					return K.advice;
				} else {
					throw "can not find advice.";
				}
			}
		}
	}});
	i(b.prototype, {initialize:function (M, L) {
		this.form = x(M);
		this.options = i({}, b.defaultOptions, L);
		var K = J(this.form, "validation");
		K && K.stop();
		this.options.autoStart && this.start();
		J(this.form, "validation", this);
	}, start:function () {
		if (this.running) {
			return this;
		}
		this.running = true;
		this.options.immediate && this._handleElms();
		this.options.onSubmit && this._handleSubmit();
		this.options.onReset && this._handleReset();
		return this;
	}, stop:function () {
		if (!this.running) {
			return this;
		}
		this.running = false;
		this.reset();
		F(I(this.form), this._removeEvent, this);
		this._removeEvent(this.form);
		return this;
	}, restart:function () {
		return this.stop().start();
	}, validate:function (K) {
		if (K === false) {
			K = {advice:false, focusOnError:false};
		}
		K = i({}, this.options, K);
		return b.validateForm(this.form, K);
	}, reset:function () {
		b.resetForm(this.form);
		return this;
	}, _handleSubmit:function () {
		var K = e(function (L) {
			if (!this.validate()) {
				H(L);
			}
		}, this);
		this._addEvent(this.form, "submit", K);
	}, _handleReset:function () {
		var K = e(function () {
			this.reset();
		}, this);
		this._addEvent(this.form, "reset", K);
	}, _handleElms:function () {
		var K = this.options;
		var L = I(this.form);
		var M = K.immediate == "keypress" ? "keypress" : "blur";
		F(L, function (R) {
			var P = function () {
				return b._validateFormElement(R, K);
			};
			var Q = P;
			var N = y(R);
			if (N != "select" && M == "keypress") {
				Q = function () {
					if (J(R, "validation_running")) {
						return;
					}
					J(R, "validation_running", true);
					var S = (K.delay || 0.5) * 1000;
					setTimeout(P, S);
					setTimeout(function () {
						u(R, "validation_running");
					}, S);
				};
			}
			var O = e(function () {
				var S = K.messages;
				K.messages = o(R, S);
				b.prompt(R, K);
				K.messages = S;
			}, this);
			this._addEvent(R, N == "select" ? "blur" : M, Q);
			this._addEvent(R, "focus", O);
		}, this);
	}, _addEvent:function (N, M, L) {
		var K = J(N, "validation_handler") || J(N, "validation_handler", []);
		K.push([M, L]);
		h(N, M, L);
	}, _removeEvent:function (L) {
		var K = J(L, "validation_handler");
		K && F(K, function (M) {
			c(L, M[0], M[1]);
		});
		u(L, "validation_handler");
	}});
	b.util = {each:F, all:p, any:v, extend:i, isEmpty:n, isArray:r, splat:f, trim:a};
	b.ui = {get:x, getTag:y, getValue:A, data:J, addEvent:h, removeEvent:c, stopEvent:H, getClasses:t, hasClass:C, addClass:q, removeClass:m, show:z, hide:G, activate:k};
	b.advice = d;
	b.Validator = l;
	B.Validation = b;
	b.noConflict = function () {
		B.Validation = s;
		return b;
	};
	b.autobind = true;
	if (b.autobind) {
		h(B, "load", function () {
			var K = document.getElementsByTagName("form");
			F(K, function (L) {
				if (C(L, "required-validate")) {
					new b(L, {immediate:true});
				}
			});
		});
	}
	b.defaultOptions = {autoStart:true, advice:"default", messageNames:{prompt:"promptmessage", passed:"passedmessage", failed:"failedmessage"}, useTitle:true, messageSeparator:/;\s*/, stopOnFirst:true, focusOnError:true, onSubmit:true, onReset:true};
	b._validators = {};
	b._validators.required = {validate:function (K) {
		return !n(K);
	}};
	b.add({integer:/^[-+]?[\d]+$/, "float":/^[-+]?\d+(\.\d+)?$/, digits:/^[1-9]\d*$/, alpha:/^[a-zA-Z]+$/, alphanum:/^[a-zA-Z0-9]+$/, identifier:/^_*[a-zA-Z]\w*$/, "less-than":[function (L, K) {
		return parseFloat(L) < K;
	}, {depends:"float"}], "great-than":[function (L, K) {
		return parseFloat(L) > K;
	}, {depends:"float"}], length:function (L, K) {
		return L.length == K;
	}, "min-length":function (L, K) {
		return L.length >= K;
	}, "max-length":function (L, K) {
		return L.length <= K;
	}, "int-range":[function (K, L) {
		K = parseInt(K);
		return K >= L[0] && K <= L[1];
	}, {depends:"integer"}], "float-range":[function (K, L) {
		K = parseFloat(K);
		return K >= L[0] && K <= L[1];
	}, {depends:"float"}], "length-range":function (K, L) {
		return K.length >= L[0] && K.length <= L[1];
	}, file:function (K, L) {
		L = f(L);
		return v(L, function (M) {
			return new RegExp("\\." + M + "$", "i").test(K);
		});
	}, date:function (W, V) {
		V = V || "y-m-d";
		V = f(V).join("-");
		var N = V.replace(/[^ymd]/g, "");
		var X = ["\\", "\\\\", "/", "\\/", ".", "\\.", "d", "(\\d{1,2})", "y", "(\\d{4}|\\d{2})", "m", "(\\d{1,2})"];
		for (var O = 0, T = X.length; O < T; O += 2) {
			V = V.replace(X[O], X[O + 1]);
		}
		var M = W.match(new RegExp("^" + V + "$"));
		if (!M) {
			return false;
		}
		var R = N.indexOf("y");
		var L = N.indexOf("m");
		var P = N.indexOf("d");
		var S = R != -1 ? M[R + 1] : 0;
		var Q = L != -1 ? M[L + 1] : 0;
		var U = P != -1 ? M[P + 1] : 0;
		var K = new Date();
		if (S && S.length == 2) {
			S = 2000 + S;
			S = S > K.getFullYear() ? S - 1000 : S;
		}
		S && K.setFullYear(S);
		Q && K.setMonth(Q - 1);
		U && K.setDate(U);
		if (S && K.getFullYear() != S || Q && K.getMonth() != Q - 1 || U && K.getDate() != U) {
			return false;
		}
		return true;
	}, time:function (L) {
		var K = L.match(/^(\d{1,2}):(\d{1,2})(:(\d{1,2}))?$/);
		if (!K) {
			return false;
		}
		return parseInt(K[1]) < 24 && parseInt(K[2]) < 60 && (!K[4] || parseInt(K[4]) < 60);
	}, datetime:function (K, M) {
		var L = K.split(/\s+/);
		if (L.length != 2) {
			return false;
		}
		var O = b.get("date");
		var N = b.get("time");
		return O.validate(L[0], M) && N.validate(L[1]);
	}, email:/\w{1,}[@][\w\-]{1,}([.]([\w\-]{1,})){1,3}$/, url:/^(http|https|ftp):\/\/(([A-Z0-9][A-Z0-9_-]*)(\.[A-Z0-9][A-Z0-9_-]*)+)(:(\d+))?\/?/i, ip:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/, "id-number":function (L) {
		if (!(/^\d{17}(\d|x)$/i.test(L) || /^\d{15}$/i.test(L))) {
			return false;
		}
		var N = parseInt(L.substr(0, 2));
		if (N < 11 || N > 91) {
			return false;
		}
		var K = L.length == 18 ? L : L.substr(0, 6) + "19" + L.substr(6, 15);
		var O = K.substr(6, 8);
		if (!new Date(O.substr(0, 4) + "/" + O.substr(4, 2) + "/" + O.substr(6, 2))) {
			return false;
		}
		if (L.length == 18) {
			L = L.replace(/x$/i, "a");
			var P = 0;
			for (var M = 17; M >= 0; M--) {
				P += (Math.pow(2, M) % 11) * parseInt(L.charAt(17 - M), 11);
			}
			if (P % 11 != 1) {
				return false;
			}
		}
		return true;
	}, chinese:/^[\u4e00-\u9fa5]+$/, telephone:/^((0[0-9]{3})?(0[12][0-9])?-?)?\d{6,8}$/, mobilephone:/(^1\d{10}$)/, zip:/^[1-9]\d{5}$/, qq:/^[1-9]\d{4,8}$/, pattern:function (K, L) {
		L = f(L).join("-");
		return new RegExp(L).test(K);
	}, equals:[function (L, K) {
		return L == A(x(f(K).join("-")));
	}, {force:true}], "required-any":[function (K, L) {
		return !n(K) || v(f(L), function (M) {
			return !n(A(x(M)));
		});
	}, {force:true}], any:function (K, L) {
		return v(f(L), function (M) {
			return b.get(M).validate(K);
		});
	}, multi:function (K, L) {
		L = f(L);
		var N = K.split(new RegExp(L[1] || "\\s+"));
		var M = b.get(L[0]);
		return p(N, function (O) {
			return M.validate(O);
		});
	}, within:function (K, L) {
		return v(f(L), function (M) {
			return K == M;
		});
	}, notwithin:function (K, L) {
		return p(f(L), function (M) {
			return K != M;
		});
	}});
	b.ajax = function (K) {
		if (typeof jQuery !== "undefined") {
			jQuery.ajax({url:K.url, type:"POST", async:false, data:K.data, success:K.success});
		} else {
			if (typeof Prototype !== "undefined") {
				new Ajax.Request(url, {asynchronous:false, parameters:K.data, onSuccess:function (M) {
					K.success(M.responseText);
				}});
			} else {
				if (typeof MooTools !== "undefined") {
					var L = new Request({url:K.url, async:false, data:K.data});
					L.addEvent("success", K.success);
					L.send();
				} else {
					B.alert("can not find ajax library(prototype mootools or jquery).");
				}
			}
		}
	};
	b.ajaxValidate = function (K) {
		return /\s*true\s*/.test(K);
	};
	b.add("ajax", function (L, N) {
		N = f(N);
		var M = N[0];
		var P = N[1] || "value";
		var O = {};
		O[P] = L;
		var K = false;
		var Q = function (R) {
			K = b.ajaxValidate(R);
		};
		b.ajax({url:M, data:O, success:Q});
		return K;
	});
})(window);

